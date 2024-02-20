import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q16639 {
    static int n, size;
    static ArrayList<Integer> numbers;
    static ArrayList<Character> operators;
    static Value[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        size = n/2 + 2;
        dp = new Value[size][size];
        numbers  = new ArrayList<>();
        operators = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                int temp = input[i] - '0';
                numbers.add(temp);
                int idx = i/2 + 1;
                dp[idx][idx] = new Value(temp, temp);
            }
            else {
                operators.add(input[i]);
            }
        }

        for (int i = 2; i < size; i++) {
            for (int j = i - 1; j > 0; j--) {
                cal(i, j);
            }
        }
        System.out.println(dp[1][size - 1].max);
        br.close();
    }
    static void cal(int x, int y){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<x-y;i++){
            Value value1 = dp[y+i+1][x];
            Value value2 = dp[y][y+i];
            int operatorIndex = y+i-1;
            if(operators.get(operatorIndex) == '+'){	//사용 연산자 '+'
                max = Math.max(max,value1.max + value2.max);
                min = Math.min(min,value1.min + value2.min);
            }else if(operators.get(operatorIndex)=='-'){	//사용 연산자 '-'
                max = Math.max(value2.max - value1.min, max);
                min = Math.min(value2.min - value1.max,min);
            }else{		//사용 연산자 '*'
                int temp = value1.max * value2.max;
                int tempMin = temp;
                int tempMax = temp;

                temp = value1.max * value2.min;
                tempMax = Math.max(temp,tempMax);
                tempMin = Math.min(temp,tempMin);

                temp = value1.min * value2.max;
                tempMax = Math.max(temp,tempMax);
                tempMin = Math.min(temp,tempMin);

                temp = value1.min * value2.min;
                tempMax = Math.max(temp,tempMax);
                tempMin = Math.min(temp,tempMin);

                max = Math.max(max,tempMax);
                min = Math.min(min,tempMin);
            }
        }
        dp[y][x] = new Value(max,min);		//최대값, 최소값 저장
    }
    static class Value {
        public int max;
        public int min;
        public Value(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
}

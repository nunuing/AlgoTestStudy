import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[1000001];
        for(int i = 2; i <=  1000000 / 2; i++){
            int temp = i * 2;
            while (temp < 1000000){
                isPrime[temp] = true;
                temp += i;
            }
        }

        int t = Integer.parseInt(br.readLine());
        int[] input = new int[t];
        for(int i = 0; i < t; i++){
            input[i] = Integer.parseInt(br.readLine());
            int answer = 0;
            for(int j = 2; j <= input[i] / 2; j++){
                if(!isPrime[j] && !isPrime[input[i] - j])
                    answer++;
            }
            System.out.println(answer);
        }
    }
}

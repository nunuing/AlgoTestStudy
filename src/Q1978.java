import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[num];
        int max = 0;
        for(int i = 0; i < num; i++){
            input[i] = Integer.parseInt(st.nextToken());
            max = (max < input[i]) ? input[i] : max;
        }

        int i = 2;
        boolean[] isPrime = new boolean[max + 1];
        isPrime[1] =  true;
        while (i <= max){
            for(int k = i * 2; k <= max; k += i){
                isPrime[k] = true;
            }
            i++;
        }

        int answer = 0;
        for(int l = 0; l < num; l++){
            if(!isPrime[input[l]])
                answer++;
        }

        System.out.println(answer);
    }
}

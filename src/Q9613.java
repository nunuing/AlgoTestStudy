import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] inputs = new int[n];
            for(int i = 0; i < n; i++){
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    answer += getGCD(inputs[i], inputs[j]);
                }
            }
            System.out.println(answer);
        }


    }
    public static int getGCD(int n, int m){
        int a = Math.max(n, m);
        int b = Math.min(n, m);

        while (a % b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }
}

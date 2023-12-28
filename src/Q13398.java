import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] left = new int[n + 1];
        left[1] = input[1];
        int answer = left[1];
        for(int i = 2; i <= n; i++){
            left[i] = Math.max(input[i], left[i - 1] + input[i]);

            answer = Math.max(answer, left[i]);
        }

        int[] right = new int[n + 1];
        right[n] = input[n];
        for(int i = n -1; i > 0; i--){
            right[i] = Math.max(input[i], right[i + 1] + input[i]);
        }

        for(int i = 2; i < n; i++){
            answer = Math.max(answer, left[i - 1] + right[i + 1]);
        }
        System.out.println(answer);
    }
}

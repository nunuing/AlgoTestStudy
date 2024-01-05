import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            input[i] = Integer.parseInt(st.nextToken());

        int[] forward = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            forward[i] = 1;
            for (int j = 1; j < i; j++) {
                if (input[j] < input[i] && forward[i] < (forward[j] + 1))
                    forward[i] = (forward[j] + 1);
            }
        }

        int[] backward = new int[n + 1];
        int answer = 1;
        for (int i = n; i > 0; i--) {
            backward[i] = 1;
            for(int j = i + 1; j <= n; j++){
                if(input[i] > input[j] && backward[i] < (backward[j] + 1))
                    backward[i] = backward[j] + 1;
            }

            int temp = forward[i] + backward[i] - 1;
            answer = Math.max(temp, answer);
        }

        System.out.println(answer);
    }
}

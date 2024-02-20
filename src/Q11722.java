import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        int answer = dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (input[j] > input[i] && dp[i] < (dp[j] + 1))
                    dp[i] = (dp[j] + 1);
            }
            answer = dp[i] > answer ? dp[i] : answer;
        }

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[1] = input[1];
        int answer = dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = input[i];
            for(int j = i -1; j > 0; j--) {
                if (input[j] < input[i] && dp[i] < (input[i] + dp[j])) {
                    dp[i] = (dp[j] + input[i]);
                }
            }
            answer = dp[i] > answer ? dp[i] : answer;
        }

        System.out.println(answer);
    }
}

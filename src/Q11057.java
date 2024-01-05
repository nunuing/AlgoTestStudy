import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11057 {
    public static final int DIV = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = j + 1; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % DIV;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n - 1][i]) % DIV;
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15990 {
    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append((dp[input][1] + dp[input][2] + dp[input][3]) % MOD + "\n");
        }


        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1788{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        int val = 1000000000;
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= Math.abs(n); i++) {
            if (n > 0) {
                dp[i] = dp[i - 1] + dp[i - 2] % val;
            }
            else {
                dp[i] = (dp[i - 2] - dp[i -1]) % val;
            }
        }

        int tn = Math.abs(n);
        if (dp[tn] < 0)
            System.out.println(-1);
        else if (dp[tn] == 0)
            System.out.println(0);
        else
            System.out.println(1);

        System.out.println(Math.abs(dp[tn]) % 1000000000);
    }
}

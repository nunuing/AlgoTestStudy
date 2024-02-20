import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2225 {
    public static final int DIV = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++){
            dp[i][1] = 1;
        }
        for(int i = 0; i <= k; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 2; j <= k; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % DIV;
            }
        }

        System.out.println(dp[n][k]);
    }
}

import java.io.*;

public class Q15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[4][10001];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[2][2] = 1;
        dp[1][3] = 1;
        dp[2][3] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            dp[1][i] = dp[1][i - 1];
            dp[2][i] = dp[2][i - 2] + dp[1][i - 2];
            dp[3][i] = dp[3][i - 3] + dp[2][i - 3] + dp[1][i - 3];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = dp[1][n] + dp[2][n] + dp[3][n];
            bw.append(answer + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501_3 {
    static int answer = 0, n;
    static int[][] consulting;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        consulting = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            //상담을 하는 경우
            if (i + consulting[i][0] <= n) {
                dp[i + consulting[i][0]] = Math.max(dp[i + consulting[i][0]], dp[i] + consulting[i][1]);
            }
            //상담을 안하는 경우
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[n]);
    }
}

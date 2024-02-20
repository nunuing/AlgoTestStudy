import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];      //n일자에 얻을 수 있는 최대 금액
        int max = -1;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[i]);
            int nday = i + t[i];
            if (nday <= n) {
                dp[nday] = Math.max(dp[nday], max + p[i]);
            }
        }
        System.out.println(dp[n]);
    }
}

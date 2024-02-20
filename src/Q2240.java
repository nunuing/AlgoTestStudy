import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] fall = new int[t + 1];
        for (int i = 1; i <= t; i++){
            fall[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[3][t + 1][w + 2];
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w + 1; j++) {
                if (fall[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                }
                else {
                    if (i == 1 && j == 1) continue;             //첫번째 위치는 1으로 고정되있기 때문에 i == 1 이고 j == 1이면 위치가 무조건 1이기 떄문에 2번으로 떨어지는 자두를 받을 수 없음
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]) + 1;
                }
            }
        }

        int answer = -1;
        for (int i = 1; i <= w + 1; i++) {
            answer = Math.max(answer, Math.max(dp[1][t][i], dp[2][t][i]));
        }

        System.out.println(answer);
    }
}

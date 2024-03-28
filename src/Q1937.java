import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {
    static int n;
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer + 1);
    }
    static int dfs(int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        dp[x][y] = 0;
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                continue;
            if (map[tx][ty] > map[x][y])
                dp[x][y] = Math.max(dp[x][y], dfs(tx, ty) + 1);
        }
        return dp[x][y];
    }
}

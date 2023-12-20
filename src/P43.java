public class P43 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }
    static public int solution(int m, int n, int[][] puddles) {
        int num = 1000000007;

        int[][] dp = new int[n + 1][m + 1];
        for (int[] temp : puddles) {
            dp[temp[1]][temp[0]] = -1;
        }
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i != 1) {
                    dp[i][j] += dp[i - 1][j] % num;
                }
                if (j != 1) {
                    dp[i][j] += dp[i][j - 1] % num;
                }
            }
        }

        return  dp[n][m] % num;
    }
}

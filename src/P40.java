public class P40 {
    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution(3));
    }
    static public int solution(int n) {
        int[] dp = new int[15];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        return dp[n];
    }
}

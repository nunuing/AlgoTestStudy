public class P41 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    static public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = j - 1 < 0 ? -1 : triangle[i - 1][j - 1] ;
                int right = j + 1 >= triangle[i - 1].length ? -1 : triangle[i - 1][j + 1];
            }
        }
        return answer;
    }
}

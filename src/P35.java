public class P35 {
    static int answer = 0;
    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    static public int solution(int k, int[][] dungeons) {
        for (int i = 1; i <= dungeons.length; i++) {
            dfs(0, i, k, new boolean[dungeons.length], dungeons);
        }
        return answer;
    }
    static void dfs(int depth, int k, int hp, boolean[] used, int[][] dungeons) {
        if (depth == k) {
            answer = Math.max(k, answer);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (!used[i] && hp >= dungeons[i][0]) {
                used[i] = true;
                dfs(depth + 1, k, hp - dungeons[i][1], used, dungeons);
                used[i] = false;
            }
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class P22 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];

        Queue<Pair> queue = new LinkedList<>();
        Pair now = new Pair(0, 0);
        queue.offer(now);
        visited[now.x][now.y] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.x == n - 1 && now.y == m - 1) {
                return visited[n - 1][m - 1];
            }

            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                    continue;

                if (maps[tx][ty] == 1 && visited[tx][ty] == 0) {
                    visited[tx][ty] = visited[now.x][now.y] + 1;
                    queue.offer(new Pair(tx, ty));
                }
            }
        }

        return -1;
    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

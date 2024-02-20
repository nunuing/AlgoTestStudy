import java.util.LinkedList;
import java.util.Queue;

public class P24 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}}, 1, 3, 7, 8));
        System.out.println(solution(new int[][]{{1,1,8,4}, {2,2,4,9}, {3,6,9,8}, {6,3,7,7}}, 9, 7, 6, 1));
        System.out.println(solution(new int[][]{{1,1,5,7}}, 1, 1, 4, 7));
        System.out.println(solution(new int[][]{{2,1,7,5}, {6,4,10,10}}, 3, 1, 7, 10));
        System.out.println(solution(new int[][]{{2,2,5,5}, {1,3,6,4}, {3,1,4,6}}, 1, 4, 6, 3));
    }
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if (map[k][j] == 1)
                        continue;
                    map[k][j] = 1;
                    if (j == x1 || j == x2 || k == y1 || k == y2)
                        map[k][j] = 2;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[101][101];
        Pair now = new Pair(characterX * 2, characterY * 2, 0);
        Queue<Pair> queue = new LinkedList<>();

        visited[now.y][now.x] = true;
        queue.offer(now);

        int targetX = itemX * 2;
        int targetY = itemY * 2;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.x == targetX && now.y == targetY) {
                return now.dist / 2;
            }

            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                if (tx < 0 || tx > 100 || ty < 0 || ty > 100)
                    continue;

                if (map[ty][tx] == 2 && !visited[ty][tx]) {
                    visited[ty][tx] = true;
                    queue.offer(new Pair(tx, ty, now.dist + 1));
                }
            }
        }

        return -1;
    }
    static class Pair{
        public int x;
        public int y;
        public int dist;
        public Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j] == '0' ? false : true;
            }
        }

        boolean[][][] visited = new boolean[n][m][k + 1];
        Block now = new Block(0, 0, true, 1, 0);

        Queue<Block> queue = new LinkedList<>();
        queue.offer(now);
        visited[now.x][now.y][0] = true;

        int[] mx = {0, 0, -1, 1};
        int[] my = {-1, 1, 0, 0};
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.dist);
                return;
            }

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                    continue;

                int wall = now.wall;
                int dist = now.dist;
                boolean day = now.day;

                if (map[tx][ty]) {          //벽일 경우
                    if (day && (wall + 1 <= k) && !visited[tx][ty][wall + 1]) {        //벽 깨도 됨
                        queue.offer(new Block(tx, ty, false, dist + 1, wall + 1));
                        visited[tx][ty][wall + 1] = true;
                    }
                    else if (!day && (wall + 1 <= k) && !visited[tx][ty][wall + 1]) {
                        queue.offer(new Block(now.x, now.y, true, dist + 1, wall));
                    }
                }
                else {      // 벽 아님
                    if (!visited[tx][ty][wall]) {
                        queue.offer(new Block(tx, ty, !day, dist + 1, wall));
                        visited[tx][ty][wall] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static class Block {
        public int x;
        public int y;
        public boolean day;
        public int dist;
        public int wall;
        public Block (int x, int y, boolean day, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.day = day;
            this.dist = dist;
            this.wall = wall;
        }
    }
}

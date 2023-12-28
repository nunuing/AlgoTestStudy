import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input[j - 1] - '0';
            }
        }
        br.close();

        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];
        Block now = new Block(1, 1, 1, 0);

        int[] mx = {0, 0, -1, 1};
        int[] my = {1, -1, 0, 0};
        visited[now.x][now.y][now.wall] = true;

        Queue<Block> queue = new LinkedList<>();
        queue.offer(now);
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.x == n && now.y == m) {
                System.out.println(now.dist);
                return;
            }

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if ((tx > 0 && tx <= n) && (ty > 0 && ty <= m)) {
                    int wall = now.wall;
                    int dist = now.dist;
                    if (map[tx][ty] == 0) {
                        if (!visited[tx][ty][wall]) {
                            visited[tx][ty][wall] = true;
                            queue.offer(new Block(tx, ty, dist + 1, wall));
                        }
                    }
                    else {
                        if ((wall + 1 <= k) && !visited[tx][ty][wall + 1]) {
                            visited[tx][ty][wall + 1] = true;
                            queue.offer(new Block(tx,ty, dist + 1, wall + 1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static class Block {
        public int x;
        public int y;
        public int dist;
        public int wall;
        public Block(int x, int y, int d, int w) {
            this.x = x;
            this.y = y;
            dist = d;
            wall = w;
        }
    }
}

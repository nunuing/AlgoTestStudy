import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {
    static int[][] map, virus;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static int n, m, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pickWalls(0);

        System.out.println(answer);
    }
    static void pickWalls(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    pickWalls(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        virus = new int[n][m];
        for (int i = 0; i < n; i++)
            virus[i] = map[i].clone();

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if ((tx >= 0 && tx < n) && (ty >= 0 && ty < m)) {
                    if (virus[tx][ty] == 0) {
                        virus[tx][ty] = 2;
                        queue.offer(new Pair(tx, ty));
                    }
                }
            }
        }

        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 0)
                    temp++;
            }
        }
        answer = Math.max(answer, temp);
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

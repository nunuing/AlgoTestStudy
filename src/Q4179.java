import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4179 {
    static int n, m;
    static char[][] map;
    static int[][] inFire;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        Pair str = new Pair(0, 0);

        inFire = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'J') {
                    str.x = i;
                    str.y = j;
                }
                else if (map[i][j] == 'F') {
                    queue.offer(new Pair(i, j));
                    inFire[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                int td = inFire[now.x][now.y];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                    continue;

                if (inFire[tx][ty] == 0 && map[tx][ty] != '#') {
                    inFire[tx][ty] = td + 1;
                    queue.offer(new Pair(tx, ty));
                }
            }
        }
        bfs(str.x, str.y);

    }

    static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        int[][] visited = new int[n][m];
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                int td = visited[now.x][now.y];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                    System.out.println(td);
                    return;
                }

                if (visited[tx][ty] == 0 && map[tx][ty] == '.') {
                    if (inFire[tx][ty] == 0 || (td + 1) < inFire[tx][ty]) {
                        visited[tx][ty] = td + 1;
                        queue.offer(new Pair(tx, ty));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
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

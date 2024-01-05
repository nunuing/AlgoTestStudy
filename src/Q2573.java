import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2573 {
    static int n, m;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
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
        br.close();

        int answer = 0;
        while (true) {
            visited = new boolean[n][m];

            int ice = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        ice++;
                        bfs(i, j);
                    }
                }
            }
            if (ice == 0){
                System.out.println(0);
                break;
            }
            else if (ice >= 2) {
                System.out.println(answer);
                break;
            }
            answer++;
            melting();
        }
    }
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];

                if (tx < 0 || tx >= n | ty < 0 || ty >= m)
                    continue;

                if (!visited[tx][ty] && map[tx][ty] > 0) {
                    visited[tx][ty] = true;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }
    }
    static void melting() {
        int[][] t_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            t_map[i] = map[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (t_map[i][j] > 0) {
                    int cnt = 0;
                    for (int k = 0; k < dx.length; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];

                        if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                            continue;

                        if (t_map[tx][ty] == 0)
                            cnt++;
                    }
                    map[i][j] -= cnt;
                    map[i][j] = map[i][j] < 0 ? 0 : map[i][j];
                }
            }
        }
    }
}

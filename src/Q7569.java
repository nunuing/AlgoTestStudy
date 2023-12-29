import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
    static int[][][] tomatoes;
    static int n, m, h, answer;
    static int[] dx = {0, 0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[][][] days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];
        for (int ih = 0; ih < h; ih++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    tomatoes[ih][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        days = new int[h][n][m];
        Queue<Position> queue = new LinkedList<>();
        for (int ih = 0; ih < h; ih++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tomatoes[ih][i][j] == 1) {
                        queue.offer(new Position(ih, i, j));
                        days[ih][i][j] = 1;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                int th = now.h + dh[i];
                int d = days[now.h][now.x][now.y];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m || th < 0 || th >= h)
                    continue;

                if (tomatoes[th][tx][ty] == 0) {
                    queue.offer(new Position(th, tx, ty));
                    days[th][tx][ty] = d + 1;
                    tomatoes[th][tx][ty] = 1;
                }
            }
        }
        answer = 0;
        if (!check()) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer - 1);
        }
    }

    static boolean check() {
        for (int ih = 0; ih < h; ih++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tomatoes[ih][i][j] == 0)
                        return false;
                    if (tomatoes[ih][i][j] == 1) {
                        answer = Math.max(answer, days[ih][i][j]);
                    }
                }
            }
        }
        return true;
    }

    static class Position {
        public int h;
        public int x;
        public int y;

        public Position(int h, int x, int y) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}

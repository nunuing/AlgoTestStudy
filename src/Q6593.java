import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6593 {
    static char[][][] map;
    static int l, r, c;
    static Position str;
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                bw.flush();
                bw.close();

                br.close();
                break;
            }

            map = new char[l][r][c];
            for (int h = 0; h < l; h++) {
                for (int i = 0; i < r; i++) {
                    char[] temp = br.readLine().toCharArray();
                    for (int j = 0; j < c; j++) {
                        map[h][i][j] = temp[j];
                        if (temp[j] == 'S')
                            str = new Position(h, i, j);
                    }
                }
                br.readLine();
            }
            bfs(str.h, str.x, str.y);
        }

    }
    static void bfs(int h, int x, int y) throws IOException {
        int[][][] visited = new int[l][r][c];
        visited[h][x][y] = 1;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(h, x, y));
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            if (map[now.h][now.x][now.y] == 'E') {
                bw.append("Escaped in " + (visited[now.h][now.x][now.y] - 1) + " minute(s).\n");
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int th = now.h + dh[i];
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                int minute = visited[now.h][now.x][now.y];

                if (th < 0 || th >= l || tx < 0 || tx >= r || ty < 0 || ty >= c)
                    continue;

                if (visited[th][tx][ty] == 0 && map[th][tx][ty] != '#') {
                    visited[th][tx][ty] = minute + 1;
                    queue.offer(new Position(th, tx, ty));
                }
            }
        }
        bw.append("Trapped!\n");
    }
    static class Position {
        public int x;
        public int y;
        public int h;
        public Position(int h, int x, int y) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}

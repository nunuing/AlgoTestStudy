import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5427 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int w, h;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];

            Pair str = new Pair(0, 0);

            Queue<Pair> queue = new LinkedList<>();
            int[][] inFire = new int[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '@') {
                        str.x = i;
                        str.y = j;
                    }
                    else if (map[i][j] == '*') {
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

                    if (tx < 0 || tx >= h || ty < 0 || ty >= w)
                        continue;

                    if (inFire[tx][ty] == 0 && map[tx][ty] != '#') {
                        inFire[tx][ty] = td + 1;
                        queue.offer(new Pair(tx, ty));
                    }
                }
            }
            bfs(str.x, str.y, map, inFire);
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void bfs(int x, int y, char[][] map, int[][] inFire) throws IOException {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        int[][] visited = new int[h][w];
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                int td = visited[now.x][now.y];

                if (tx < 0 || tx >= h || ty < 0 || ty >= w) {
                    bw.append(td + "\n");
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
        bw.append("IMPOSSIBLE\n");
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

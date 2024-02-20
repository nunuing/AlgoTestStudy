import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {1, -1, 0, 0, -1, -2, -2, -1,  1,  2,  2,  1};
        int[] dy = {0, 0, 1, -1,  -2,  -1,  1,  2, -2, -1, 1, 2};
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0));

        int[][][] visited = new int[k + 1][h][w];
        visited[0][0][0] = 1;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if (now.x == h - 1 && now.y == w - 1) {
                System.out.println(visited[now.horse][now.x][now.y] - 1);
                return;
            }

            int dist = visited[now.horse][now.x][now.y];
            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                int th = now.horse;
                if (tx < 0 || tx >= h || ty < 0 || ty >= w)
                    continue;

                if (i < 4) {
                    if (visited[th][tx][ty] == 0 && map[tx][ty] == 0) {
                        visited[th][tx][ty] = dist + 1;
                        queue.offer(new Pair(tx, ty, th));
                    }
                }
                else {
                    if (th + 1 >  k)
                        continue;
                    if (visited[th + 1][tx][ty] == 0 && map[tx][ty] == 0){
                        visited[th + 1][tx][ty] = dist + 1;
                        queue.offer(new Pair( tx, ty, th + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static class Pair {
        public int x;
        public int y;
        public int horse;
        public Pair(int x, int y, int horse) {
            this.x = x;
            this.y = y;
            this.horse = horse;
        }
    }
}

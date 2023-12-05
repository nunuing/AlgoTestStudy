import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        char[][] map = new char[h][w];
        Pair str = null;
        Pair dest = null;
        for (int i = 0; i < h; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (temp[j] == 'C' && str == null)
                    str = new Pair(i, j, 0, 0);
                else if (temp[j] == 'C' && str != null)
                    dest = new Pair(i, j, 0 ,0);
                map[i][j] = temp[j];
            }
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(visited[i], w * h);
        }

        visited[str.x][str.y] = 0;
        queue.offer(new Pair(str.x, str.y, 0, 5));
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            if (now.x == dest.x && now.y == dest.y) {
                System.out.println(now.m);
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                if (Math.abs(now.dir - i) == 2)
                    continue;
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                if (tx < 0 || tx >= h || ty < 0 || ty >= w)
                    continue;

                int temp = now.m;
                if (map[tx][ty] == '*')
                    continue;
                if (now.dir != 5 && now.dir != i) {
                    temp++;
                }
                if (visited[tx][ty] < temp)
                    continue;

                visited[tx][ty] = temp;
                queue.offer(new Pair(tx, ty, temp, i));

            }

        }
    }
    static class Pair {
        public int x;
        public int y;
        public int m;
        public int dir;
        public Pair(int x, int y, int m, int dir) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.dir = dir;
        }
    }
}

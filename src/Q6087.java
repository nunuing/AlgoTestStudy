import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
                    str = new Pair(i, j);
                else if (temp[j] == 'C' && str != null)
                    dest = new Pair(i, j);
                map[i][j] = temp[j];
            }
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[h][w];

        visited[str.x][str.y] = 0;
        queue.offer(new Pair(str.x, str.y));
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                while (tx >= 0 && tx < h && ty >= 0 && ty < w && map[tx][ty] != '*') {
                    if (visited[tx][ty] == 0) {
                        visited[tx][ty] = visited[now.x][now.y] + 1;
                        queue.offer(new Pair(tx, ty));
                    }
                    tx += dx[i];
                    ty += dy[i];
                }
            }
        }
        System.out.println(visited[dest.x][dest.y] - 1);
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

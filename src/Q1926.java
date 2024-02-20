import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926 {
    static int[][] pic;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer  st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pic = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int cnt = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && pic[i][j] == 1) {
                    cnt++;
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(cnt + "\n" + answer);
    }
    static int bfs(int x, int y) {
        int cnt = 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        visited[x][y] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                    continue;

                if (!visited[tx][ty] && pic[tx][ty] == 1){
                    cnt++;
                    visited[tx][ty] = true;
                    queue.offer(new Pair(tx, ty));
                }
            }
        }
        return cnt;
    }
    static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

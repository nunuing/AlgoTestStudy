import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sea = new int[n][m];
        LinkedList<Pair> sharks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 1) {
                    sharks.add(new Pair(i, j));
                }
            }
        }

        int[] mx = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] my = {-1, 1, 0, 0, 1, -1, 1, -1};
        int[][][] visited = new int[sharks.size()][n][m];

        int cur = 0;
        int answer = 0;
        for (Pair s : sharks) {
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(s);
            visited[cur][s.x][s.y] = 1;
            while (!queue.isEmpty()) {
                Pair now = queue.poll();

                for (int i = 0; i < mx.length; i++) {
                    int tx = now.x + mx[i];
                    int ty = now.y + my[i];
                    int dist = visited[cur][now.x][now.y];

                    if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                        continue;

                    if (visited[cur][tx][ty] == 0) {
                        queue.offer(new Pair(tx, ty, dist + 1));
                        visited[cur][tx][ty] = dist + 1;
                    }
                }
            }
            cur++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = n * m;
                for (int s = 0; s < sharks.size(); s++) {
                    if (temp > visited[s][i][j] - 1)
                        temp = visited[s][i][j] - 1;
                }
                if (temp > answer)
                    answer = temp;
            }
        }
        System.out.println(answer);
    }
    static class Pair {
        public int x;
        public int y;
        public int dist = 0;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

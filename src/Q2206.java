import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = temp[j - 1] - '0';
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        Pair now = new Pair(1, 1, 1, false);

        boolean[][][] visited = new boolean[n + 1][m + 1][2];

        queue.offer(now);

        int[] mx = {0, 0, -1, 1};
        int[] my = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.x == n && now.y == m) {
                System.out.println(now.cnt);
                return;
            }

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if ((tx > 0 && tx <= n) && (ty > 0 && ty <= m)) {
                    if (map[tx][ty] == 0) {
                        if (!now.wall && !visited[tx][ty][0]) {
                            queue.offer(new Pair(tx, ty, now.cnt + 1, false));
                            visited[tx][ty][0] = true;
                        }
                        else if (now.wall && !visited[tx][ty][1]) {
                            queue.offer(new Pair(tx, ty, now.cnt + 1, true));
                            visited[tx][ty][1] = true;
                        }
                    }
                    else if (map[tx][ty] == 1) {
                        if (!now.wall) {
                            queue.offer(new Pair(tx, ty, now.cnt + 1, true));
                            visited[tx][ty][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static class Pair{
        public int x;
        public int y;
        public int cnt;
        public boolean wall;
        public Pair(int x, int y, int cnt, boolean wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
}

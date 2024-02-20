import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q10026 {
    static int n;
    static char[][] map;
    static int[][] group1, group2;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();

        int cnt = 1;
        group1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group1[i][j] == 0) {
                    bfs_normal(i, j, cnt++);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt - 1+ " ");

        group2 = new int[n][n];
        cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group2[i][j] == 0) {
                    bfs_special(i, j, cnt++);
                }
            }
        }

        sb.append(cnt - 1);
        System.out.println(sb);
    }
    static void bfs_normal(int x, int y, int gnum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        group1[x][y] = gnum;

        char nchar = map[x][y];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];
                if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                    continue;

                if (group1[tx][ty] == 0 && map[tx][ty] == nchar) {
                    queue.offer(new int[] {tx, ty});
                    group1[tx][ty] = gnum;
                }
            }
        }
    }
    static void bfs_special(int x, int y, int gnum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        group2[x][y] = gnum;

        char nchar = map[x][y];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];
                if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                    continue;

                if (nchar == 'G' && map[tx][ty] == 'B')
                    continue;
                if (nchar == 'B' && (map[tx][ty] == 'G' || map[tx][ty] == 'R'))
                    continue;
                if (nchar == 'R' && map[tx][ty] == 'B')
                    continue;

                if (group2[tx][ty] == 0) {
                    queue.offer(new int[] {tx, ty});
                    group2[tx][ty] = gnum;
                }
            }
        }
    }
}

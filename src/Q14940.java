import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];
        int[] now = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2) {
                    now[0] = i;
                    now[1] = j;
                } else
                    map[i][j] = temp == 1 ? true : false;
            }
        }

        br.close();

        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        visited[now[0]][now[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(now);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                    continue;

                if (!visited[tx][ty] && map[tx][ty]) {
                    dist[tx][ty] = dist[now[0]][now[1]] + 1;
                    visited[tx][ty] = true;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j])
                    bw.append("0 ");
                else if (!visited[i][j])
                    bw.append("-1 ");
                else
                    bw.append(dist[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

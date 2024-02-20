import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14466 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean[][][] bridge = new boolean[4][n + 1][n + 1];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int tr = Integer.parseInt(st.nextToken());
            int tc = Integer.parseInt(st.nextToken());
            int tpr = Integer.parseInt(st.nextToken());
            int tpc = Integer.parseInt(st.nextToken());

            int gx = tpr - tr;
            int gy = tpc - tc;
            if (gx == 1 && gy == 0) {
                bridge[0][tr][tc] = true;
                bridge[1][tpr][tpc] = true;
            }
            else if (gx == -1 && gy == 0) {
                bridge[1][tr][tc] = true;
                bridge[0][tpr][tpc] = true;
            }
            else if (gx == 0 && gy == 1) {
                bridge[2][tr][tc] = true;
                bridge[3][tpr][tpc] = true;
            }
            else if (gx == 0 && gy == -1) {
                bridge[3][tr][tc] = true;
                bridge[2][tpr][tpc] = true;
            }
        }

        boolean[][] map = new boolean[n + 1][n + 1];
        int[][] cows = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
            cows[i][0] = x;
            cows[i][1] = y;
        }

        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < k; i++) {
            int[][] visited = new int[n + 1][n + 1];
            queue.offer(cows[i]);
            visited[cows[i][0]][cows[i][1]] = 1;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int tx = now[0] + dx[j];
                    int ty = now[1] + dy[j];

                    if (tx <= 0 || tx > n || ty <= 0 || ty > n)
                        continue;

                    if (visited[tx][ty] == 0 && !bridge[j][now[0]][now[1]]) {
                        visited[tx][ty] = visited[now[0]][now[1]] + 1;
                        queue.offer(new int[]{tx, ty});
                    }
                }
            }
            for (int check = 0; check < k; check++) {
                int cx = cows[check][0];
                int cy = cows[check][1];

                if (visited[cx][cy] == 0)
                    answer++;
            }
        }
        System.out.println(answer / 2);
    }
}

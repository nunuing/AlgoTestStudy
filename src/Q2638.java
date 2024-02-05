import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2638 {
    static int n, m;
    static int[][] cheese;
    static boolean[][] air;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheese = new int[n][m];
        int cheeses = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1)
                    cheeses++;
            }
        }

        int time = 0;
        while (true) {
            if (cheeses == 0)
                break;

            air = new boolean[n][m];
            check();
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cheese[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < dx.length; k++) {
                            int tx = i + dx[k];
                            int ty = j + dy[k];

                            if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                                continue;

                            if (cheese[tx][ty] == 0 && air[tx][ty]) {
                                cnt++;
                            }
                        }
                        if (cnt >= 2) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }

            for (int[] melt : list) {
                cheese[melt[0]][melt[1]] = 0;
                cheeses--;
            }
            time++;
        }
        System.out.println(time);
    }
    static void check() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        air[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];

                if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                    continue;

                if (cheese[tx][ty] == 0 && !air[tx][ty]) {
                    air[tx][ty] = true;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }
    }
}

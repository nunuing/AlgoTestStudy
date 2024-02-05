import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2638 {
    static int n, m;
    static boolean[][] cheese, air;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheese = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        air = new boolean[n][m];

        int time = 1;
        while (true) {
            check();
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (cheese[i][j]) {
                        int cnt = 0;
                        for (int k = 0; k < dx.length; k++) {
                            int tx = i + dx[k];
                            int ty = j + dy[k];

                            if (tx < 0 || tx >= n || ty < 0 || ty >= m)
                                continue;

                            if (!cheese[tx][ty] && air[tx][ty]) {
                                cnt++;
                            }
                        }
                        if (cnt >= 2) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }
            if (list.size() == 0)
                break;

            for (int[] melt : list) {
                cheese[melt[0]][melt[1]] = false;
            }
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

                if (!air[tx][ty] && !cheese[tx][ty]) {
                    air[tx][ty] = true;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }
    }
}

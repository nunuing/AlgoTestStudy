import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16234 {
    static int n, l, r;
    static int[][] map, visited;
    static boolean flag;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            int group = 0;
            visited = new int[n][n];
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        bfs(i, j, ++group);
                    }
                }
            }

            if (!flag)
                break;
            day++;
        }
        System.out.println(day);
    }
    static void bfs(int x, int y, int group) {
        ArrayList<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        int people = map[x][y];
        list.add(new int[]{x, y});
        queue.offer(new int[]{x, y});
        visited[x][y] = group;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];
                if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                    continue;

                if (visited[tx][ty] != 0)
                    continue;

                int gap = Math.abs(map[now[0]][now[1]] - map[tx][ty]);
                if (gap >= l && gap <= r) {
                    list.add(new int[]{tx, ty});
                    people += map[tx][ty];
                    visited[tx][ty] = group;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }
        if (list.size() > 1)
            flag = true;

        for (int[] now : list) {
            map[now[0]][now[1]] = people / list.size();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2583 {
    static int n, m;
    static boolean[][] paper, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        paper = new boolean[m + 1][n + 1];
        for (int cnt = 0; cnt < k; cnt++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for (int i = sx + 1; i <= ex; i++) {
                for (int j = sy + 1; j <= ey; j++) {
                    paper[j][i] = true;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        visited = new boolean[m + 1][n + 1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++) {
                if (!visited[j][i] && !paper[j][i]){
                    list.add(bfs(i, j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int a : list)
            System.out.print(a + " ");
        System.out.println();
    }
    static int bfs(int x, int y) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[y][x] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];

                if (tx <= 0 || tx > n || ty <= 0 || ty > m)
                    continue;

                if (!visited[ty][tx] & !paper[ty][tx]){
                    cnt++;
                    visited[ty][tx] = true;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }
        return cnt;
    }
}

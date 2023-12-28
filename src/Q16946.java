import java.io.*;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16946 {
    static int[][] map, visited;
    static int n, m, group;
    static HashMap<Integer, Integer> hm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j] - '0';
            }
        }
        br.close();
        hm = new HashMap<>();
        visited = new int[n][m];
        group = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && visited[i][j] == 0) {
                    hm.put(group, bfs(group, i, j));
                    group++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    sb.append(checking(i, j));
                }
                else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int checking (int nx, int ny) {
        int cnt = 1;
        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};

        boolean[] used = new boolean[group];
        for (int i = 0; i < mx.length; i++) {
            int tx = nx + mx[i];
            int ty = ny + my[i];

            if ((tx >= 0 && tx < n) && (ty >= 0 && ty < m)) {
                if (map[tx][ty] == 0) {
                    int gnum = visited[tx][ty];
                    if (!used[gnum]) {
                        cnt += hm.get(gnum);
                        used[gnum] = true;
                    }
                }
            }
        }
        return cnt % 10;
    }
    static int bfs (int group, int nx, int ny) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {nx, ny});
        visited[nx][ny] = group;

        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
           int[] now = queue.poll();

            for (int i = 0; i < mx.length; i++) {
                int tx = now[0] + mx[i];
                int ty = now[1] + my[i];

                if ((tx >= 0 && tx < n) && (ty >= 0 && ty < m)) {
                    if (map[tx][ty] == 0 && visited[tx][ty] == 0) {
                        queue.offer(new int[] {tx, ty});
                        visited[tx][ty] = group;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}

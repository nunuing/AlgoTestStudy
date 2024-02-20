import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1113 {
    static int[][] map;
    static int n, m, min;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static List<int[]> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++){
            char[] temp = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = temp[j - 1] - '0';
            }
        }

        visited = new boolean[n + 2][m + 2];
        int result = 0;
        for (int num = 1; num < 10; num++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (map[i][j] == num && !visited[i][j]) {
                        nodes = new LinkedList<>();
                        min = 9;
                        visited[i][j] = true;
                        dfs(i, j, num);
                        if (min > num) {
                            int temp = min - num;
                            for (int[] pos : nodes) {
                                map[pos[0]][pos[1]] = min;
                                visited[pos[0]][pos[1]] = false;
                                result += temp;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
    static void dfs(int x, int y, int num) {
        nodes.add(new int[]{x, y});
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (map[tx][ty] != 0) {
                if (map[tx][ty] != num) {
                    min = Math.min(min, map[tx][ty]);
                    continue;
                }
                if (visited[tx][ty])
                    continue;
                visited[tx][ty] = true;
                dfs(tx, ty, num);
            }
            else {
                min = 0;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1303 {
    static char[][] map;
    static int n, m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[m][n];
        int wTeam = 0, bTeam = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int temp = bfs(map[i][j], new Pair(i, j));
                    if (map[i][j] == 'W') {
                        wTeam += temp;
                    }
                    else {
                        bTeam += temp;
                    }
                }

            }
        }
        System.out.println(wTeam + " " + bTeam);
    }
    static int bfs(char c, Pair str) {
        int sum = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(str);
        visited[str.x][str.y] = true;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                if (tx < 0 || tx >= m || ty < 0 || ty >= n)
                    continue;

                if (!visited[tx][ty] && map[tx][ty] == c) {
                    visited[tx][ty] = true;
                    queue.offer(new Pair(tx, ty));
                    sum++;
                }
            }
        }
        return sum * sum;
    }
    static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

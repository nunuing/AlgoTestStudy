import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] wall = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                wall[i][j] = input[j - 1] - '0';
            }
        }

        int[][] visited = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited[i], -1);
        }

        Queue<Pair> queue = new LinkedList<>();
        Pair now = new Pair(1, 1);
        visited[now.x][now.y] = 0;

        queue.offer(now);

        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            now = queue.poll();

            for (int i = 0; i < mx.length; i++) {
                int dx = now.x + mx[i];
                int dy = now.y + my[i];

                if ((dx > 0 && dx <= n) && (dy > 0 && dy <= m)) {
                    if(visited[dx][dy] == -1){
                        visited[dx][dy] = visited[now.x][now.y] + wall[dx][dy];
                        queue.offer(new Pair(dx, dy));
                    }
                    else if (visited[dx][dy] != -1 && visited[dx][dy] > visited[now.x][now.y] + wall[dx][dy]) {
                        visited[dx][dy] = visited[now.x][now.y] + wall[dx][dy];
                        queue.offer(new Pair(dx, dy));
                    }
                }
            }
        }
        System.out.println(visited[n][m]);
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

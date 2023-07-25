import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2146 {
    static int n;
    static boolean[][] map;
    static int[][] land;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new boolean[n][n];
        land = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(land[i], 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
            }
        }
        br.close();

        int iNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0 && map[i][j]) {
                    findIsland(new Pair(i, j), iNum++);
                }
            }
        }

        answer = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]) {
                    bridge(new Pair(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    static void findIsland(Pair now, int num) {
        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};

        Stack<Pair> stack = new Stack<>();
        boolean[][] visited = new boolean[n][n];

        Pair pos = now;
        stack.push(pos);
        while (!stack.empty()) {
            pos = stack.pop();
            if (visited[pos.x][pos.y])
                continue;
            visited[pos.x][pos.y] = true;
            land[pos.x][pos.y] = num;
            for (int i = 0; i < mx.length; i++) {
                int dx = pos.x + mx[i];
                int dy = pos.y + my[i];

                if ((dx >= 0 && dx < n) && (dy >= 0 && dy < n)) {
                    if (map[dx][dy] && !visited[dx][dy]) {
                        stack.push(new Pair(dx, dy));
                    }
                }
            }
        }
    }

    static void bridge(Pair now) {
        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};

        Queue<Pair> queue = new LinkedList<>();
        Pair pos = now;
        queue.offer(pos);

        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];
        dist[pos.x][pos.y] = 0;
        int num = land[pos.x][pos.y];

        while (!queue.isEmpty()) {
            pos = queue.poll();
            if (visited[pos.x][pos.y])
                continue;

            visited[pos.x][pos.y] = true;
            for (int i = 0; i < mx.length; i++) {
                int dx = pos.x + mx[i];
                int dy = pos.y + my[i];

                if ((dx >= 0 && dx < n) && (dy >= 0 && dy < n)) {
                    if (!visited[dx][dy]) {
                        if (land[dx][dy] == 0) {
                            dist[dx][dy] = dist[pos.x][pos.y] + 1;
                            queue.offer(new Pair(dx, dy));
                        } else if (land[dx][dy] != num) {
                            answer = dist[pos.x][pos.y] < answer ? dist[pos.x][pos.y] : answer;
                        }
                    }
                }
            }
        }
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

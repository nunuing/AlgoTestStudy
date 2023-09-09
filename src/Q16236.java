import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16236 {
    static int n, size;
    static int[][] sea;
    static Pair shark;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        sea = new int[n][n];
        StringTokenizer st;
        size = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                   shark = new Pair(i, j, 0);
                }
            }
        }
        PriorityQueue<Pair> fishes = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.dist > o2.dist)
                    return 1;
                if (o1.dist < o2.dist)
                    return 0;
                if (o1.dist == o2.dist) {
                    if (o1.x > o2.x)
                        return 1;
                    else if (o1.x < o2.y)
                        return -1;
                    else if (o1.y < o2.y)
                        return -1;
                    else if (o1.y > o2.y)
                        return 1;
                }
                return 0;
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sea[i][j] >= 1 && sea[i][j] <= 6) {
                    fishes.offer(new Pair(i, j , bfs(i, j)));
                }
            }
        }

        while (!fishes.isEmpty()) {

        }
    }
    static int bfs(int dx, int dy) {
        boolean[][] visited = new boolean[n][n];

        Pair now = shark;
        visited[now.x][now.y] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(now);

        int[] mx = {0, 0, -1, 1};
        int[] my = {-1, 1, 0, 0};
        while (!queue.isEmpty()) {
            if (now.x == dx && now.y == dy) {
                return now.dist;
            }

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if ((tx >= 0 && tx < n) && (ty >= 0 && ty < n)) {
                    if (sea[tx][ty] != 0)
                        continue;
                    if (!visited[tx][ty]) {
                        visited[tx][ty] = true;
                        queue.offer(new Pair(tx, ty, now.dist + 1));
                    }
                }
            }
        }
        return n * n;
    }
    static class Pair {
        public int x;
        public int y;
        public int dist;
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

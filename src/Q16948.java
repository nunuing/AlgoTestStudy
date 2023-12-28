import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], -1);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        Pair now = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Pair dest = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int[] mx = {-2, -2, 0, 0, 2, 2};
        int[] my = {-1, 1, -2, 2, -1, 1};

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(now);
        map[now.x][now.y] = 0;

        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.x == dest.x && now.y == dest.y)
                break;

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if ((tx >= 0 && tx < n) && (ty >= 0 && ty < n)) {
                    if (map[tx][ty] == -1) {
                        map[tx][ty] = map[now.x][now.y] + 1;
                        queue.offer(new Pair(tx, ty));
                    }
                }
            }
        }

        System.out.println(map[dest.x][dest.y]);
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

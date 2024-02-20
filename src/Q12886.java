import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12886 {
    static int a, b, c, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sum = a + b + c;
        System.out.println(bfs() ? 1 : 0);

    }
    static boolean bfs() {
        if (sum % 3 != 0) {
            return false;
        }

        Queue<Stones> queue = new LinkedList<>();
        Stones now = new Stones(a, b, c);
        boolean[][] visited = new boolean[sum + 1][sum + 1];

        queue.offer(now);
        visited[a][b] = true;
        while (!queue.isEmpty()) {
            now = queue.poll();

            int a = now.a;
            int b = now.b;
            int c = now.c;
            if ((a == b) && (b == c))
                return true;

            if (a != b) {
                int ta = a < b ? 2 * a : a - b;
                int tb = b < a ? 2 * b : b - a;

                if (!visited[ta][tb]) {
                    visited[ta][tb] = true;
                    queue.offer(new Stones(ta, tb, c));
                }
            }
            if (a != c) {
                int ta = a < c ? 2 * a : a - c;
                int tc = c < a ? 2 * c : c - a;

                if (!visited[ta][tc]) {
                    visited[ta][tc] = true;
                    queue.offer(new Stones(ta, b, tc));
                }
            }
            if (b != c) {
                int tb = b < c ? 2 * b : b - c;
                int tc = c < b ? 2 * c : c - b;

                if (!visited[tb][tc]) {
                    visited[tb][tc] = true;
                    queue.offer(new Stones(a, tb, tc));
                }
            }
        }
        return false;
    }
    static class Stones {
        public int a;
        public int b;
        public int c;
        public Stones(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

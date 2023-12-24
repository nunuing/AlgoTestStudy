import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            pairs[i] = new Pair(tx, ty);
        }

        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            total += pairs[i].dist(pairs[i + 1]);
        }

        int answer = total;
        for (int i = 1; i < n - 1; i++) {
            int temp = total;
            temp -= pairs[i].dist(pairs[i - 1]);
            temp -= pairs[i].dist(pairs[i + 1]);

            temp += pairs[i - 1].dist(pairs[i + 1]);
            answer = Math.min(answer, temp);
        }

        System.out.println(answer);
    }
    static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int dist(Pair p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }
}

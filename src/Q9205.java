import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Pair[] store = new Pair[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair home = new Pair(x, y);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                store[i] = new Pair(x, y);
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            Pair dest = new Pair(x, y);
            store[n] = dest;

            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i <= n; i++) {
                int dist = Math.abs(store[i].x - home.x) + Math.abs(store[i].y - home.y);
                if (dist <= 1000) {
                    queue.offer(i);
                }
            }
            int now = -1;
            while (!queue.isEmpty()) {
                now = queue.poll();
                if (now == n)
                    break;
                Pair pnow = store[now];
                for (int i = 0; i <= n; i++) {
                    if (visited[i])
                        continue;
                    int dist = Math.abs(store[i].x - pnow.x) + Math.abs(store[i].y - pnow.y);
                    if (dist <= 1000) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
            if (now != n)
                bw.append("sad\n");
            else
                bw.append("happy\n");
        }
        bw.flush();
        bw.close();
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

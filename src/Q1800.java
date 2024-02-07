import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1800 {
    static int n, p, k;
    static ArrayList<Cable>[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        computers = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            computers[i] = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            computers[c1].add(new Cable(c2, price));
            computers[c2].add(new Cable(c1, price));
        }

        int left = 0;
        int right = 10000000;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean check(int mid) {
        PriorityQueue<Cable> pq = new PriorityQueue<>();
        pq.offer(new Cable(1, 0));
        int[] visited = new int[n + 1];

        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[1] = 0;
        while (!pq.isEmpty()){
            Cable now = pq.poll();
            int nn = now.num;
            int price = now.price;
            if (visited[nn] < mid)
                continue;

            for (Cable next : computers[nn]) {

            }

        }
        return visited[n] <= k;
    }
    static class Cable implements Comparable<Cable> {
        public int num;
        public int price;
        public Cable(int num, int price) {
            this.num = num;
            this.price = price;
        }

        @Override
        public int compareTo(Cable o) {
            return this.price - o.price;
        }
    }
}


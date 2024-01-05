import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P7 {
    static final int INF = 200 * 100000 + 1;
    static LinkedList<Edge>[] map;
    public static void main(String[] args) {
        System.out.println(solution(6,4,6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(solution(7,3,4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(solution(6,4,5, 6, new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
    }
    static public int solution(int n, int s, int a, int b, int[][] fares) {
        map = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new LinkedList<>();

        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            map[fare[0]].add(new Edge(fare[1], fare[2]));
            map[fare[1]].add(new Edge(fare[0], fare[2]));
        }

        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        int[] distS = new int[n + 1];

        Arrays.fill(distA, INF);
        Arrays.fill(distB, INF);
        Arrays.fill(distS, INF);

        distA = Dijkstra(distA, a);
        distB = Dijkstra(distB, b);
        distS = Dijkstra(distS, s);

        int answer = INF;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }
        return answer;
    }
    static public int[] Dijkstra(int[] dist, int str) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(str, 0));
        dist[str] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int n_num = now.num;
            int n_dist = now.dist;

            if (n_dist > dist[n_num])
                continue;

            for (Edge e : map[now.num]) {
                int t_dist = dist[n_num] + e.dist;
                if (t_dist < dist[e.num]) {
                    dist[e.num] = t_dist;
                    pq.offer(new Edge(e.num, t_dist));
                }
            }
        }
        return dist;
    }
    static class Edge implements Comparable<Edge>{
        public int num;
        public int dist;
        public Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.dist, e.dist);
        }
    }
}

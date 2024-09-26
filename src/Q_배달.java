import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Q_배달 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3));
        System.out.println(solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));
    }
    static public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node>[] map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            map[r[0]].add(new Node(r[1], r[2]));
            map[r[1]].add(new Node(r[0], r[2]));
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : map[cur.num]) {
                if (dist[next.num] > cur.dist + next.dist) {
                    dist[next.num] = cur.dist + next.dist;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }

        for (int a : dist) {
            if (a <= K)
                answer++;
        }
        return answer;
    }
    static class Node implements Comparable<Node>{
        public int num;
        public int dist;
        public Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}

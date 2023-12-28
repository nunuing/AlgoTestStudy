import java.util.LinkedList;
import java.util.Queue;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] {{3, 6}, {4, 3},{3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
    static public int solution(int n, int[][] edge) {
        int answer = 0, dist = 0;
        LinkedList<Integer>[] map = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new LinkedList<>();

        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0]].add(edge[i][1]);
            map[edge[i][1]].add(edge[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int now = 1;
        queue.offer(now);
        int[] visited = new int[n + 1];
        visited[now] = 1;
        while (!queue.isEmpty()) {
            now = queue.poll();

            for (int p : map[now]) {
                if (visited[p] == 0) {
                    visited[p] = visited[now] + 1;
                    queue.offer(p);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist < visited[i]) {
                dist = visited[i];
                answer = 1;
            }
            else if (dist == visited[i]) {
                answer++;
            }
        }
        return answer;
    }
}

import java.util.*;
public class P6 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static public int solution(int n, int[][] computers) {
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                visited[i] = cnt;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (visited[j] == -1 && computers[now][j] == 1) {
                            queue.offer(j);
                            visited[j] = visited[now];
                        }
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }
}


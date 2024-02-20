import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5567 {
    static ArrayList<Integer>[] map;
    static int answer;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[s].add(d);
            map[d].add(s);
        }

        answer = 0;
        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int dist = visited[now];
            if (dist == 1 || dist == 2)
                answer++;

            for (int next : map[now]) {
                if (visited[next] == -1) {
                    visited[next] = dist + 1;
                    queue.offer(next);
                }
            }
        }


        System.out.println(answer);
    }
}

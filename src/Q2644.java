import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2644 {
    static ArrayList<Integer>[] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            map[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int tparent = Integer.parseInt(st.nextToken());
            int tchild =Integer.parseInt(st.nextToken());

            map[tchild].add(tparent);
            map[tparent].add(tchild);
        }
        br.close();

        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(x);
        visited[x] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : map[now]) {
                if (visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(visited[y]);
    }
}

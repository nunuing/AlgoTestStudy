import java.io.*;
import java.util.*;

public class Q1260 {
    static int n, m, v;
    static boolean[][] map;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], false);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int str = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            map[str][dest] = true;
            map[dest][str] = true;
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dfs();
        bfs();

        bw.flush();
        bw.close();

        br.close();
    }

    static void dfs() throws IOException {
        boolean[] visited = new boolean[n + 1];
        int now = v;

        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();
        stack.push(now);
        while (!stack.empty()) {
            now = stack.pop();
            if (!visited[now]) {
                visited[now] = true;
                bw.append(now + " ");
            }
            for (int i = n; i > 0; i--) {
                if (!visited[i] && map[now][i]) {
                    stack.add(i);
                }
            }
        }
        bw.write("\n");
    }

    static void bfs() throws IOException {
        boolean[] visited = new boolean[n + 1];
        int now = v;

        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);

        while (!queue.isEmpty()) {
            now = queue.remove();
            if (!visited[now]) {
                visited[now] = true;
                bw.append(now + " ");
            }
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && map[now][i]) {
                    queue.add(i);
                }
            }
        }
        bw.write("\n");
    }
}

import java.io.*;
import java.util.*;

public class Q1325 {
    static int n;
    static ArrayList<Integer>[] map;
    static boolean[][] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dest = Integer.parseInt(st.nextToken());
            int str = Integer.parseInt(st.nextToken());

            map[str].add(dest);
        }
        dist = new int[n + 1];
        visited = new boolean[n + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            dfs(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                bw.append(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int str) {
        for (int next : map[str]) {
            visited[str][next] = true;
            dfs(next);
            dist[str] += dist[next];
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24479 {
    static int n;
    static int m;
    static int r;
    static int order;
    static ArrayList<Integer>[] map;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map[n1].add(n2);
            map[n2].add(n1);
        }


        visited = new int[n + 1];
        //dfs 함수호출
        Arrays.fill(visited, 0);
        order = 1;
        dfs(r);
        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }
    }
    static void dfs(int now) {
        visited[now] = order;

        Collections.sort(map[now]);
        for (int next : map[now]) {
            if (visited[next] == 0) {
                order++;
                dfs(next);
            }
        }
    }
}

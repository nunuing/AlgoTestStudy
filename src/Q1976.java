import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1976 {
    static LinkedList<Integer>[] map;
    static boolean[][] reachable;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    map[i + 1].add(j + 1);
                }
            }
        }

        reachable = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            bfs(i);

        int[] order = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < m; i++) {
            int str = order[i - 1];
            int dest = order[i];
            if (!reachable[str][dest]){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static void bfs(int str) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(str);
        reachable[str][str] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : map[now]) {
                if (!reachable[str][next]) {
                    queue.offer(next);
                    reachable[str][next] = true;
                }
            }
        }
    }
}

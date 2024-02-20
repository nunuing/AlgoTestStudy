import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14225 {
    static int n;
    static int[] s;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        visited = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            dfs(i, s[i]);
        }

        int idx = 1;
        while (visited[idx]) {
            idx++;
        }
        System.out.println(idx);
    }

    static void dfs(int now, int sum) {
        visited[sum] = true;

        for (int i = now + 1; i < n; i++) {
            dfs(i, sum + s[i]);
        }
    }
}

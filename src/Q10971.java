import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10971 {
    static int n, answer;
    static int[][] cost;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        cost = new int[n][n];
        visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            visited[i] = false;
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            visit(1, i, i, 0);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    static void visit(int cnt, int str, int now, int sum) {
        if (cnt == n) {
            if (cost[now][str] != 0) {
                sum += cost[now][str];
                answer = sum < answer ? sum : answer;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && cost[now][i] != 0) {
                visited[i] = true;
                visit(cnt + 1, str, i, sum + cost[now][i]);
                visited[i] = false;
            }
        }
    }
}

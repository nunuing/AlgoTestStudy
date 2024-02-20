import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q11734 {
    static int n;
    static boolean[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first][second] = true;
            map[second][first] = true;
        }

        visited = new boolean[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }

    static void dfs(int now) {
        Stack<Integer> stack = new Stack<>();

        stack.push(now);
        while (!stack.empty()) {
            now = stack.pop();
            if (visited[now])
                continue;
            visited[now] = true;
            for(int i = 1; i <= n; i++){
                if(!visited[i] && map[now][i]){
                    stack.push(i);
                }
            }
        }
    }
}

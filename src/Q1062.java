import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1062 {
    static char[][] words;
    static int n, k, answer = 0;
    static boolean[] visited = new boolean['z' - 'a' + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (k < 5) {
            System.out.println(0);
            return;
        }
        else if (k == 26) {
            System.out.println(n);
            return;
        }

        words = new char[n][];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().toCharArray();
        }
        //a,n,t,i,c
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        dfs(1, 5);
        System.out.println(answer);
    }
    static void dfs(int now, int depth) {
        if (depth > k)
            return;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean readable = true;
            for (int j = 0; j < words[i].length; j++) {
                int tc = words[i][j] - 'a';
                if (!visited[tc]) {
                    readable = false;
                    break;
                }
            }
            if (readable){
                cnt++;
            }
        }

        if (answer < cnt) {
            answer = cnt;
        }

        for (int i = now; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}

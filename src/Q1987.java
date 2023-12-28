import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
    static int n, m, answer;
    static char[][] board;
    static boolean[] visited = new boolean['Z' - 'A' + 1];
    static int[] mx = {0, 0, 1, -1};
    static int[] my = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++){
            board[i] = br.readLine().toCharArray();
        }
        br.close();

        answer = 1;
        visited[board[0][0] - 'A'] = true;
        dfs(new Pair(0, 0), 1);

        System.out.println(answer);

    }
    static void dfs(Pair now, int level) {
        if (answer < level)
            answer = level;

        for (int i = 0; i < mx.length; i++) {
            int tx = now.x + mx[i];
            int ty = now.y + my[i];

            if ((tx >= 0 && tx < n) && (ty >= 0 && ty < m)) {
                int val = board[tx][ty] - 'A';
                if (!visited[val]){
                    visited[val] = true;
                    dfs(new Pair(tx, ty), level + 1);
                    visited[val] = false;
                }
            }
        }
    }
    static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16929 {
    static char[][] board;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                visited[i][j] = true;
                dfs(new Pair(i, j), 1);
            }
        }
        System.out.println("NO");
    }

    static void dfs(Pair now, int level) {
        int[] mx = {0, 0, 1, -1};
        int[] my = {1, -1, 0, 1};

        for (int i = 0; i < mx.length; i++){
            int dx = now.x + mx[i];
            int dy = now.y = my[i];
            if((dx >= 0 && dx < n) && (dy >= 0 && dy < m) && (board[now.x][now.y] == board[dx][dy])){
                if(!visited[dx][dy]){
                    visited[dx][dy] = true;
                }
            }
        }

    }

    static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

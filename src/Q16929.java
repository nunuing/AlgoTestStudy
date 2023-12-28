import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16929 {
    static char[][] board;
    static boolean[][] visited;
    static int n, m;
    static Pair first;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        br.close();

        check = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                first = new Pair(i, j);
                visited = new boolean[n][m];
                visited[i][j] = true;
                dfs(new Pair(i, j), 1);
                if(check){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    static void dfs(Pair now, int level) {
        int[] mx = {1, 0, -1, 0};
        int[] my = {0, 1, 0, -1};

        for (int i = 0; i < mx.length; i++) {
            int dx = now.x + mx[i];
            int dy = now.y + my[i];
            if ((dx >= 0 && dx < n) && (dy >= 0 && dy < m) && (board[now.x][now.y] == board[dx][dy])) {
                if (!visited[dx][dy]) {
                    visited[dx][dy] = true;
                    dfs(new Pair(dx, dy), level + 1);
                } else {
                    if (level >= 4 && (first.x == dx) && (first.y == dy)) {
                        check = true;
                        return;
                    }
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

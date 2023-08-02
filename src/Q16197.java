import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        int[][] visited1 = new int[n][m];
        int[][] visited2 = new int[n][m];

        Pair coin1 = null, coin2 = null;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            Arrays.fill(visited1[i], -1);
            Arrays.fill(visited2[i], -1);
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'o') {
                    if (coin1 == null)
                        coin1 = new Pair(i, j);
                    else
                        coin2 = new Pair(i, j);
                }
            }
        }

        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};

        Queue<Pair[]> queue = new LinkedList<>();
        Pair[] now = {coin1, coin2};

        visited1[now[0].x][now[0].y] = 0;
        visited2[now[1].x][now[1].y] = 0;

        queue.offer(now);
        while (!queue.isEmpty()) {
            now = queue.poll();

        }
    }
    static class Pair {
        public int x;
        public int y;
        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

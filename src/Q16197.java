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
        int[][][][] visited = new int[n][m][n][m];

        Pair coin1 = null, coin2 = null;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
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
        visited[now[0].x][now[0].y][now[1].x][now[1].y] = 1;

        queue.offer(now);
        boolean flag = false;
        int answer = 1;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (visited[now[0].x][now[0].y][now[1].x][now[1].y] > 11){
                break;
            }

            for (int i = 0; i < mx.length; i++) {
                Pair temp1 = new Pair(now[0].x + mx[i], now[0].y + my[i]);
                Pair temp2 = new Pair(now[1].x + mx[i], now[1].y + my[i]);

                if (temp1.x < 0 || temp1.x >= n || temp1.y < 0 || temp1.y >= m) {
                    flag = true;
                    answer = visited[now[0].x][now[0].y][now[1].x][now[1].y];
                    break;
                }
                else if (temp2.x < 0 || temp2.x >= n || temp2.y < 0 || temp2.y >= m) {
                    flag = true;
                    answer = visited[now[0].x][now[0].y][now[1].x][now[1].y];
                    break;
                }

                if (board[temp1.x][temp1.y] == '#')
                    temp1 = now[0];
                else if (board[temp2.x][temp2.y] == '#')
                    temp2 = now[0];

                if (visited[temp1.x][temp1.y][temp2.x][temp2.y] == 0) {
                    visited[temp1.x][temp1.y][temp2.x][temp2.y] = visited[now[0].x][now[0].y][now[1].x][now[1].y] + 1;
                    queue.offer(new Pair[]{temp1, temp2});
                }
            }
            if (flag)
                break;
        }
        if (flag) {
            System.out.println(answer);
        }
        else
            System.out.println(-1);
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

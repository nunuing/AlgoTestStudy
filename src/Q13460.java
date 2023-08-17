import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        Pair dest = null, red = null, blue = null;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R')
                    red = new Pair(i, j);
                else if (board[i][j] == 'B')
                    blue = new Pair(i, j);
                else if (board[i][j] == 'O')
                    dest = new Pair(i, j);
            }
        }
        br.close();

        Pair[] now = {red, blue};
        Queue<Pair[]> queue = new LinkedList<>();
        queue.offer(now);

        int[][][][] visited = new int[n][m][n][m];
        visited[now[0].x][now[0].y][now[1].x][now[1].y] = 1;

        boolean success = false;
        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now[0].isSame(dest)) {
                success = true;
                System.out.println(visited[now[0].x][now[0].y][now[1].x][now[1].y] - 1);
                break;
            }
            else if (now[1].isSame(dest))
                continue;
            else if (visited[now[0].x][now[0].y][now[1].x][now[1].y] > 11) {
                break;
            }

            for (int i = 0; i < mx.length; i++) {
                int rx = now[0].x;
                int ry = now[0].y;
                int bx = now[1].x;
                int by = now[1].y;

                while (board[rx + mx[i]][ry + my[i]] != '#') {
                    rx += mx[i];
                    ry += my[i];
                    if (board[rx][ry] == 'O')
                        break;
                }

                while (board[bx + mx[i]][by + my[i]] != '#') {
                    bx += mx[i];
                    by += my[i];
                    if (board[bx][by] == 'O')
                        break;
                }
                if ((dest.x == rx && dest.y == ry) && (dest.x == bx && dest.y == by))
                    continue;

                if (rx == bx && ry == by) {
                    if (i == 0) {       //방향 : 상
                        if (now[0].x < now[1].x)
                            bx += 1;
                        else
                            rx += 1;
                    }
                    else if (i == 1) {      //하
                        if (now[0].x > now[1].x)
                            bx -= 1;
                        else
                            rx -= 1;
                    }
                    else if (i == 2) {  //좌
                        if (now[0].y < now[1].y)
                            by += 1;
                        else
                            ry += 1;
                    }
                    else {      //우
                        if (now[0].y > now[1].y)
                            by -= 1;
                        else
                            ry -= 1;
                    }
                }
                if (visited[rx][ry][bx][by] == 0) {
                    visited[rx][ry][bx][by] = visited[now[0].x][now[0].y][now[1].x][now[1].y] + 1;
                    queue.offer(new Pair[]{new Pair(rx, ry), new Pair(bx, by)});
                }
            }
        }
        if (!success)
            System.out.println(-1);

    }
    static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean isSame(Pair p) {
            return x == p.x && y == p.y;
        }
    }
}

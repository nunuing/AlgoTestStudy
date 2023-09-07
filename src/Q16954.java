import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q16954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] board = new boolean[8][8];

        Queue<Pair> walls = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (input[j] == '.')
                    board[i][j] = true;
                else {
                    board[i][j] = false;
                    cnt++;
                    walls.offer(new Pair(i, j));
                }
            }
        }

        Pair now = new Pair(7, 0);
        Queue<Pair> queue = new LinkedList<>();

        boolean[][] visited = new boolean[8][8];
        queue.offer(now);
        visited[now.x][now.y] = true;

        while (!queue.isEmpty()) {
            now = queue.poll();

            if (now.x == 0 && now.y == 7) {
                System.out.println(1);
                return;
            }

        }
        System.out.println(0);
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

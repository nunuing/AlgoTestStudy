import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.Queue;

public class Q16954 {
    static final int SIZE = 8;
    static int[] mx = {0, 0, -1, 1, -1, -1, 1, 1, 0};
    static int[] my = {-1, 1, 0, 0, -1, 1, 1, -1, 0};
    static char[][][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[SIZE][SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < SIZE; j++) {
                board[0][i][j] = input[j];
            }
        }
        br.close();

        for (int step = 1; step < SIZE; step++) {
            for (int i = 0; i < SIZE - 1; i++) {
                for (int j = 0; j < SIZE; j++) {
                    board[step][i + 1][j] = board[step - 1][i][j];
                }
            }
            for (int i = 0; i < SIZE; i++) {
                board[step][0][i] = '.';
            }
        }

        if (dfs(new Pair(SIZE - 1, 0), 0))
            System.out.println(1);
        else
            System.out.println(0);
    }
    static boolean dfs(Pair now, int depth) {
        if (depth == SIZE - 1){ //8번이면 벽이 사라져서 무조건 성공
            return true;
        }
        if (now.x == 0 && now.y == SIZE - 1) {
            return true;
        }
        for (int i = 0; i < mx.length; i++) {
            int tx = now.x + mx[i];
            int ty = now.y + my[i];

            if (tx < 0 || tx >= SIZE || ty < 0 || ty >= SIZE)
                continue;

            if (board[depth][tx][ty] == '.' && board[depth + 1][tx][ty] == '.') {
                if (dfs(new Pair(tx, ty), depth + 1)) {
                    return true;
                }
            }
        }
        return false;
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

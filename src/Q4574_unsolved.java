import java.io.*;
import java.util.StringTokenizer;

public class Q4574_unsolved {
    static int n, pcnt;
    static BufferedReader br;
    static StringBuilder sb;
    static boolean isDone;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        pcnt = 1;
        while (n != 0) {
            board = new int[9][9];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int temp1 = Integer.parseInt(st.nextToken());
                char[] pos1 = st.nextToken().toCharArray();

                int temp2 = Integer.parseInt(st.nextToken());
                char[] pos2 = st.nextToken().toCharArray();

                int px = pos1[0] - 'A';
                int py = pos1[1] - '1';
                board[px][py] = temp1;

                px = pos2[0] - 'A';
                py = pos2[1] - '1';
                board[px][py] = temp2;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 10; i++) {
                char[] pos = st.nextToken().toCharArray();

                int px = pos[0] - 'A';
                int py = pos[1] - '1';

                board[px][py] = i;
            }

            isDone = false;
            sudoku(0, 0);

            n = Integer.parseInt(br.readLine());
            pcnt++;
        }
        br.close();
        System.out.print(sb);
    }
    static void sudoku (int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }
        if (row == 9) {
            if (!isDone) {
                sb.append("Puzzle " + pcnt + "\n");
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(board[i][j]);
                    }
                    sb.append("\n");
                }
                isDone = true;
            }
            return;
        }

        if(board[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (possibility(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }
    static boolean possibility(int col, int row, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[i][row] == val)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[col][i] == val)
                return false;
        }

        int t_col = (col / 3) * 3;
        int t_row = (row / 3) * 3;
        for (int i = t_col; i < t_col + 3; i++) {
            for (int j = t_row; j < t_row + 3; j++) {
                if (board[i][j] == val)
                    return false;
            }
        }

        return true;
    }
}

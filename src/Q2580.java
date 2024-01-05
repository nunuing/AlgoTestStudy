import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2580 {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        board = new int[9][9];
        for (int i = 0;  i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        sudoku(0, 0);
    }
    static void sudoku (int row, int col) throws IOException {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }
        if (row == 9) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.append(board[i][j] + " ");
                }
                bw.append("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
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

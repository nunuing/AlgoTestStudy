import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100_unsolved {
    static int n, answer = 0;
    static int[][] board;
    static boolean[][] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();


        System.out.println(answer);
    }
    static void dfs(int depth) {
        if (depth == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        int[][] origin = new int[n][n];
        for (int i = 0; i < n; i++)
            origin[i] = board[i].clone();
        for (int dir = 0; dir < 4; dir++) {
            move(dir);
            dfs(depth + 1);
            for (int i = 0; i < n; i++){
                board[i] = origin[i].clone();
            }
        }
    }
    static void move(int dir) {
        used = new boolean[n][n];
        if (dir == 0) {
            for (int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        if (board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[index - 1][i] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
            }
        }
        else if (dir == 1) {

        }
        else if (dir == 2) {

        }
        else {

        }
    }

}

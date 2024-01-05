import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14890 {
    static int[][] board;
    static int n, l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (calCol(i)) cnt++;
            if (calRow(i)) cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean calRow(int row) {
        boolean[] incline = new boolean[n];
        for(int i = 0; i < n - 1; i++) {
            int diff = board[row][i] - board[row][i + 1];

            if(diff > 1 || diff < -1) return false;
            else if(diff == -1) {
                for(int j = 0; j < l; j++) {
                    if(i - j < 0 || incline[i - j]) return false;
                    if(board[row][i] != board[row][i - j]) return false;
                    incline[i - j]  = true; //경사면 설치
                }
            }
            else if(diff == 1) {
                for(int j = 1; j <= l; j++) {
                    if(i + j >= n || incline[i + j]) return false;
                    if(board[row][i] - 1 != board[row][i + j]) return false;
                    incline[i + j] = true; //경사면 설치
                }
            }
        }
        return true;
    }

    public static boolean calCol(int col) {
        boolean[] incline = new boolean[n];
        for(int i = 0; i < n - 1; i++) {
            int diff = board[i][col] - board[i + 1][col];

            if(diff > 1 || diff < -1) return false; //높이차 1 초과하므로 false
            else if(diff == -1) { // 다음 계단이 한 계단 높다
                for(int j = 0; j < l; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if(i - j < 0 || incline[i - j]) return false;
                    if(board[i][col] != board[i - j][col]) return false;
                    incline[i - j]  = true; //경사면 설치
                }
            }
            else if(diff == 1) { //다음 계단이 한 계단 낮다
                for(int j = 1; j <= l; j++) { //내려가는 경사로를 설치할 수 있는지 확인한다.
                    if(i + j >= n || incline[i + j]) return false;
                    if(board[i][col] - 1 != board[i + j][col]) return false;
                    incline[i + j] = true; //경사면 설치
                }
            }
        }
        return true;
    }
}

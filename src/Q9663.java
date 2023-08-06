import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
    static int n, cnt = 0;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        br.close();

        board = new int[n];
        nQueen(0);

        System.out.println(cnt);
    }
    static void nQueen(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[depth] = i;

            if(possible(depth))
                nQueen(depth + 1);
        }
    }
    static boolean possible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth] == board[i])
                return false;
            else if (Math.abs(depth - i) == Math.abs(board[depth] - board[i]))
                return false;
        }
        return true;
    }
}

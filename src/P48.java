public class P48 {
    public static void main(String[] args) {

    }

    static public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for (int[] s : skill) {
            int d = s[0] == 1 ? -s[5] : s[5];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];

            sum[r1][c1] += d;
            sum[r1][c2 + 1] -= d;
            sum[r2 + 1][c1] -= d;
            sum[r2 + 1][c2 + 1] += d;

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sum[i + 1][j] += sum[i][j];
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                sum[j][i + 1] += sum[j][i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100 {
    static int n, answer = 0;
    static Block[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new Block[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = new Block(val);
            }
        }
        br.close();

        move(0);
        System.out.println(answer);
    }
    static class Block {
        public int val;
        public boolean isUsed = false;
        public Block(int val) {
            this.val = val;
        }
        public Block(int val, boolean isUsed) {
            this.val = val;
            this.isUsed = isUsed;
        }
    }
    static void move(int depth) {
        if (depth > 0 && depth <= 5) {
            int maxVal = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j].val > maxVal)
                        maxVal = board[i][j].val;
                }
            }
            if (answer < maxVal)
                answer = maxVal;
        }
        else if(depth > 5)
            return;

        for (int i = 0; i < 4; i++) {
            if (i == 0) {                               //상
                for (int ty = 0; ty < n; ty++) {
                    int tx = 0;
                    int cx = tx + 1;
                    while (tx < n && cx < n) {
                        //합쳐저야되는 경우
                        if ((!board[tx][ty].isUsed && !board[cx][ty].isUsed) && (board[tx][ty].val == board[cx][ty].val)) {
                            board[cx][ty].val = 0;

                            board[tx][ty].val *= 2;
                            board[ty][ty].isUsed = true;
                        }
                        else if (board[cx][ty].val == 0){
                            cx++;
                            continue;
                        }
                        tx++;
                        cx = tx + 1;
                    }
                }
            }
            else if (i == 1) {                          //하
                for (int ty = 0; ty < n; ty++) {
                    int tx = n - 1;
                    int cx = tx - 1;
                    while (tx >= 0 && cx >= 0   ) {
                        //합쳐저야되는 경우
                        if ((!board[tx][ty].isUsed && !board[cx][ty].isUsed) && (board[tx][ty].val == board[cx][ty].val)) {
                            board[tx][ty].val = 0;

                            board[cx][ty].val *= 2;
                            board[cx][ty].isUsed = true;
                        }
                        else if (board[cx][ty].val == 0){
                            cx++;
                            continue;
                        }
                        tx = cx;
                        cx = tx + 1;
                    }
                }
            }
            else if (i == 2) {                          //좌
                for (int tx = 0; tx < n; tx++) {
                    int ty = n - 1;
                    int cy = ty - 1;
                    while (ty > 0 && cy >= 0) {
                        //합쳐저야되는 경우
                        if ((!board[tx][ty].isUsed && !board[tx][cy].isUsed) && (board[tx][ty].val == board[tx][cy].val)) {
                            board[tx][ty].val = 0;

                            board[tx][cy].val *= 2;
                            board[tx][cy].isUsed = true;
                        }
                        else if (board[tx][cy].val == 0) {
                            cy--;
                            continue;
                        }
                        ty = cy;
                        cy = ty - 1;
                    }
                }
            }
            else if (i == 3) {                          //우
                for (int tx = 0; tx < n; tx++) {
                    int ty = 0;
                    int cy = ty + 1;
                    while (ty < n - 1 && cy < n) {
                        //합쳐저야되는 경우
                        if ((!board[tx][ty].isUsed && !board[tx][ty + 1].isUsed) && (board[tx][ty].val == board[tx][ty + 1].val)) {
                            board[tx][ty].val = 0;

                            board[tx][ty + 1].val *= 2;
                            board[tx][ty + 1].isUsed = true;
                        }
                        else if (board[tx][cy].val == 0) {
                            cy++;
                            continue;
                        }
                        ty = cy;
                        cy = ty - 1;
                    }
                }
            }
            move(depth + 1);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3085 {
    static char[][] inputs;
    static int n;
    static int maxVal = 1;

    public static void row(int r) {
        int temp = 1;
        char stand = inputs[r][1];

        for (int i = 2; i <= n; i++) {
            if (stand != inputs[r][i]) {
                maxVal = Math.max(maxVal, temp);
                temp = 1;
                stand = inputs[r][i];
            } else
                temp++;

        }
        maxVal = Math.max(maxVal, temp);
    }

    public static void col(int c) {
        int temp = 1;
        char stand = inputs[1][c];

        for (int i = 2; i <= n; i++) {
            if (stand != inputs[i][c]) {
                maxVal = Math.max(maxVal, temp);
                temp = 1;
                stand = inputs[i][c];
            } else
                temp++;
        }
        maxVal = Math.max(maxVal, temp);
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = inputs[x1][y1];
        inputs[x1][y1] = inputs[x2][y2];
        inputs[x2][y2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        inputs = new char[n + 1][n + 1];
        char[] chars;
        for (int i = 1; i <= n; i++) {
            chars = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                inputs[i][j] = chars[j - 1];
            }
            row(i);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 1; i <= n; i++) {
            col(i);
        }

        for (int i = 1; i <= n; i++) {            //x좌표
            for (int j = 1; j <= n; j++) {        //y좌표
                for (int k = 0; k < 4; k++) {
                    if ((i + dx[k] >= 1 && i + dx[k] <= n) && (j + dy[k] >= 1 && j + dy[k] <= n)) {
                        swap(i, j, i + dx[k], j + dy[k]);
                        row(i);
                        if (k < 2)
                            row(i + dx[k]);
                        col(j);
                        if(k >= 2)
                            col(j + dy[k]);

                        swap(i, j, i + dx[k], j + dy[k]);
                    }
                }
            }
        }

        System.out.println(maxVal);
    }
}

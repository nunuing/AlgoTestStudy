import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arrB = new int[h + x][w + y];
        for (int i = 0; i < arrB.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrB[0].length; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[][] arrA = new int[h][w];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < w; j++) {
                arrA[i][j] = arrB[i][j];
            }
        }

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < h; i++) {
                arrA[i][j] = arrB[i][j];
            }
        }

        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                arrA[i][j] = arrB[i][j] - arrA[i - x][j - y];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arrA[i][j] + " ");
            }
            System.out.println();
        }
    }
}

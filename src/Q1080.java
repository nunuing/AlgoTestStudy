import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arrA = new int[n][m];
        int[][] arrB = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arrA[i][j] = temp[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arrB[i][j] = temp[j] - '0';
            }
        }

        int answer = 0;
        for (int i = 0; i + 3 <= n; i++) {
            for (int j = 0; j + 3 <= m; j++) {
                if (arrA[i][j] == arrB[i][j])
                    continue;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        arrA[i + k][j + l] = arrA[i + k][j + l] == 0 ? 1 : 0;
                    }
                }
                answer++;
            }
        }

        if (check(arrA, arrB))
            System.out.println(answer);
        else
            System.out.println(-1);
    }
    static boolean check(int[][] arrA, int[][] arrB) {
        for (int i = 0; i < arrA.length; i++) {
            for (int j = 0; j < arrA[0].length; j++) {
                if (arrA[i][j] != arrB[i][j])
                    return false;
            }
        }
        return true;
    }
}

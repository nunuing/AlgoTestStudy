import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1248 {
    static int n;
    static char[][] matrix;
    static int[] result;
    static boolean isFirst = true;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[] input = br.readLine().toCharArray();
        matrix = new char[n][n];

        int i = 0, j = 0;
        for (int idx = 0; idx < input.length; idx++) {
            matrix[i][j++] = input[idx];
            if (j > n - 1) {
                j = ++i;
            }
        }

        result = new int[n];
        find_sequence(0);
        br.close();
    }

    static void find_sequence(int cnt) {
        if (cnt == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            System.exit(0);
            return;
        }

        for (int i = -10; i <= 10; i++) {
            result[cnt] = i;
            if (checking(cnt)) {
                find_sequence(cnt + 1);
            }
        }
    }

    static boolean checking(int now) {
        int i, j;
        for (i = 0; i <= now; i++) {
            int sum = 0;
            for (j = i; j <= now; j++) {
                sum += result[j];
                
                if (matrix[i][j] == '+' && sum <= 0) {
                    return false;
                } else if (matrix[i][j] == '-' && sum >= 0) {
                    return false;
                } else if (matrix[i][j] == '0' && sum != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

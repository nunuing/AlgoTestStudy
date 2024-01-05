import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2529 {
    static int n;
    static char[] inputs;
    static boolean[] picked;
    static int[] result;
    static int[][] answer;
    static boolean isFirst;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        char[] temp = br.readLine().toCharArray();
        inputs = new char[n];
        int idx = 0;
        for (int i = 0; i < temp.length; i += 2) {
            inputs[idx++] = temp[i];
        }

        picked = new boolean[10];
        Arrays.fill(picked, false);

        result = new int[n + 1];
        answer = new int[2][n + 1];
        isFirst = true;
        picking(0);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }

    static void picking(int cnt){
        if (cnt == n + 1) {
            boolean isOK = true, isBigger = true, pass = true;
            for (int i = 1; i < result.length; i++) {
                isBigger = inputs[i - 1] == '<' ? true : false;
                isOK = result[i - 1] < result[i] ? true : false;

                if (isBigger ^ isOK) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                int idx = isFirst ? 1 : 0;
                for (int i = 0; i < result.length; i++) {
                    answer[idx][i] = result[i];
                }
                isFirst = false;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!picked[i]) {
                picked[i] = true;
                result[cnt] = i;
                picking(cnt + 1);
                picked[i] = false;
            }
        }
    }
}
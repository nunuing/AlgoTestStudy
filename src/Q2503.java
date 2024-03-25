import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2503 {
    static int[][] hint, info;
    static int n, answer;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hint = new int[n][3];
        info = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            hint[i][2] = temp % 10;
            temp /= 10;
            hint[i][1] = temp % 10;
            temp /= 10;
            hint[i][0] = temp;

            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        used = new boolean[10];
        dfs(0, new int[3]);
        System.out.println(answer);
    }

    static void dfs(int depth, int[] result) {
        if (depth == 3) {
            if (check(result)) {
                answer++;
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                result[depth] = i;
                dfs(depth + 1, result);
                used[i] = false;
            }
        }
    }

    static boolean check(int[] result) {
        for (int i = 0; i < n; i++) {
            int strike = 0;
            int ball = 0;
            // strike 개수 세기
            if (result[0] == hint[i][0])
                strike++;
            if (result[1] == hint[i][1])
                strike++;
            if (result[2] == hint[i][2])
                strike++;
            if (strike != info[i][0])
                return false;

            if (result[0] == hint[i][1] || result[0] == hint[i][2])
                ball++;
            if (result[1] == hint[i][0] || result[1] == hint[i][2])
                ball++;
            if (result[2] == hint[i][0] || result[2] == hint[i][1])
                ball++;

            if (ball != info[i][1])
                return false;
        }
        return true;
    }
}

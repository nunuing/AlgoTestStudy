import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[][] amount = new int[n + 1][3];
        amount[1][0] = 0;
        amount[1][1] = wine[1];
        amount[1][2] = 0;

        for (int i = 2; i <= n; i++) {
            amount[i][0] = Math.max(amount[i - 1][0], Math.max(amount[i - 1][1], amount[i - 1][2]));        //i번째 잔 선택 안 하는 경우
            amount[i][1] = amount[i-1][0] + wine[i];            //i-1번째 잔 선택 안하고 i번째 잔 선택
            amount[i][2] = amount[i-1][1] + wine[i];            //i-1번째 잔 선택 하고 i번째 잔 선택 이때 amount[i-1][2]는 i-2를 선택하는 경우이므로 포함해선 안된다.
        }

        System.out.println(Math.max(amount[n][0], Math.max(amount[n][1], amount[n][2])));
    }
}

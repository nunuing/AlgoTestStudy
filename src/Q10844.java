import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {
    public static final int DIV = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];        //dp[자릿수][해당 숫자]

        //첫번째 자리 수 초기화 -> 한 자리수의 경우 한 가지 경우의 수 뿐!
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        //두번째 자리수부터 계산
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][1] % DIV;
                else if (j == 9)
                    dp[i][j] = dp[i - 1][8] % DIV;
                else
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % DIV;
            }
        }

        long answer = 0;
        for(int i = 1; i < 10; i++){
            answer += dp[n][i];
        }

        System.out.println(answer % DIV);
    }
}

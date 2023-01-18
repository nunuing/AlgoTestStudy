import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int[] dp = new int[input + 1];

        dp[0] = 0;
        dp[1] = 0;

        //bottom-up 방법 사용
        //3가지 경우가 존재
        //i-1에서 1을 더하는 경우 dp[i] = dp[i-1] + 1;
        //i가 2로 나누어 떨어질 때, i/2에서 2를 곱하는 경우 dp[i] = dp[i/2] + 1
        //i가 3으로 나누어 떨어질 때, i/3에서 3을 곱하는 경우 dp[i] = dp[i/3] + 1;
        //위 3가지 경우 중 가장 작은 값을 취하면 됨
        for(int i = 2; i <= input; i++){
         dp[i] = dp[i - 1] + 1;
         if(i % 2 == 0)
             dp[i] = Math.min(dp[i], dp[i / 2] + 1);
         if(i % 3 == 0)
             dp[i] = Math.min(dp[i], dp[i /3] + 1);
        }

        System.out.println(dp[input]);
    }
}

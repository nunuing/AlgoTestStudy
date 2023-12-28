import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Q11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){     //업데이트하고자하는 인덱스
            dp[i] = 1;
            for(int j = 1; j <= n; j++) {   //비교값 인덱스
                if (input[i] > input[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }

        int answer = dp[1];
        for(int i = 2; i <= n; i++)
            answer = answer > dp[i] ? answer : dp[i];

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int[] track = new int[n + 1];

        dp[1] = 1;
        track[1] = 1;

        int max = dp[1];
        int idx = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j <= n; j++) {
                if (input[i] > input[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    track[i] = j;
                }
            }
            if(max < dp[i]){
                max = dp[i];
                idx = i;
            }
            max = max > dp[i] ? max : dp[i];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max + "\n");

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < max; i++){
            stack.push(input[idx]);
            idx = track[idx];
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] input = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] cost = new int[n + 1][n + 1];

        cost[1][1] = input[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    cost[i][j] = cost[i - 1][1] + input[i][1];
                } else if (j == i) {
                    cost[i][j] = cost[i - 1][j - 1] + input[i][j];
                } else {
                    cost[i][j] = Math.max(cost[i - 1][j - 1], cost[i - 1][j]) + input[i][j];
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = answer < cost[n][i] ? cost[n][i] : answer;
        }

        System.out.println(answer);
    }
}

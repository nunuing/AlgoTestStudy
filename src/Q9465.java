import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] sticker = new int[n + 1][3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                sticker[i][1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                sticker[i][2] = Integer.parseInt(st.nextToken());

            int[][] cost = new int[n + 1][3];
            cost[1][0] = 0;
            cost[1][1] = sticker[1][1];
            cost[1][2] = sticker[1][2];

            for (int i = 2; i <= n; i++) {
                cost[i][0] = Math.max(cost[i - 1][0], Math.max(cost[i - 1][1], cost[i - 1][2]));
                cost[i][1] = Math.max(cost[i - 1][0] + sticker[i][1], cost[i - 1][2] + sticker[i][1]);
                cost[i][2] = Math.max(cost[i - 1][0] + sticker[i][2], cost[i - 1][1] + sticker[i][2]);
            }

            sb.append(Math.max(cost[n][0], Math.max(cost[n][1], cost[n][2])) + "\n");
        }
        System.out.print(sb);
    }
}

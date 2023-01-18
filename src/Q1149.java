import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] houses = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] cost = new int[n + 1][3];
        cost[1][0] = houses[1][0];
        cost[1][1] = houses[1][1];
        cost[1][2] = houses[1][2];

        for (int i = 2; i <= n; i++) {
            cost[i][0] += (houses[i][0] + Math.min(cost[i - 1][1], cost[i - 1][2]));
            cost[i][1] += (houses[i][1] + Math.min(cost[i - 1][0], cost[i - 1][2]));
            cost[i][2] += (houses[i][2] + Math.min(cost[i - 1][0], cost[i - 1][1]));
        }

        System.out.println(Math.min(cost[n][0], Math.min(cost[n][1], cost[n][2])));
    }
}

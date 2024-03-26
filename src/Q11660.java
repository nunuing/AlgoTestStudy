import java.io.*;
import java.util.StringTokenizer;

public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] input = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[n + 1][n + 1];
        sum[1][1] = input[1][1];
        for (int i = 1; i < n; i++) {
            sum[i][1] = sum[i - 1][1] + input[i][1];
            sum[1][i] = sum[1][i - 1] + input[1][i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = input[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] p1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] p2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            bw.append(sum[p2[0]][p2[1]] - sum[p1[0] - 1][p2[1]] - sum[p2[0]][p1[1] - 1] + sum[p1[0] - 1][p1[1] - 1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] stuff = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {

        }

    }
}

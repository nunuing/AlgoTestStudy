import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++){
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j] - '0';
            }
        }
        System.out.println();
    }
}

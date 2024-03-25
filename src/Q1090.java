import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] coordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinate[i][0] = Integer.parseInt(st.nextToken());
            coordinate[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (Math.abs(coordinate[i][0] - coordinate[j][0]) + Math.abs(coordinate[i][1] - coordinate[j][1]));
            }
            Arrays.sort(dist[i]);
        }

        int[] answer = new int[n];
        for (int i = 1; i <= n; i++) {
            int min = -1;
            for (int j = 0; j < n; j++) {
                int temp = 0;
                for (int k = 0; k < i; k++) {
                    temp += dist[j][k];
                }
                if (min == -1)
                    min = temp;
                else
                    min = Math.min(min, temp);
            }
        }
    }
}

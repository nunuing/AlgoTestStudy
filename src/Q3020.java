import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] obstacle = new int[h + 1];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                obstacle[0] += 1;
                obstacle[temp] -= 1;
            }
            else {
                obstacle[h] -= 1;
                obstacle[h - temp] += 1;
            }
        }
        for (int i = 1; i < h; i++) {
            obstacle[i] = obstacle[i] + obstacle[i - 1];
        }
        Arrays.sort(obstacle);
        int min = obstacle[1];
        int cnt = 1;
        for (int i = 2; i <= h; i++) {
            if (min == obstacle[i])
                cnt++;
            else
                break;
        }
        System.out.println(min + " " + cnt);
    }
}

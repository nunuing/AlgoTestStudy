import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] cars = new int[3][2];
        int[] cnt = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            cars[i][0] = Integer.parseInt(st.nextToken());
            cars[i][1] = Integer.parseInt(st.nextToken());
            for (int j = cars[i][0]; j < cars[i][1]; j++) {
                cnt[j]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] == 1) {
                answer += a;
            }
            else if (cnt[i] == 2) {
                answer += (b * 2);
            }
            else if (cnt[i] == 3) {
                answer += (c * 3);
            }
        }

        System.out.println(answer);
    }
}

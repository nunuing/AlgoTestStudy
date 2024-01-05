import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1182 {
    static int[] data, result;
    static int n, s, answer;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        data = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        used = new boolean[n];
        Arrays.fill(used, false);
        result = new int[n];
        answer = 0;

        picking(0, 0);

        System.out.println(answer);
    }

    static void picking(int cnt, int now) {
        if (cnt > n) {
            return;
        }
        if (cnt > 0) {
            int sum = 0;
            for (int i = 0; i < cnt; i++) {
                sum += result[i];
            }
            if (sum == s) {
                answer++;
            }
        }

        for (int i = now; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                result[cnt] = data[i];
                picking(cnt + 1, i + 1);
                used[i] = false;
            }
        }
    }
}

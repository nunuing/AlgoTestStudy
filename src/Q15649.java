import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] picked = new boolean[n + 1];
        int[] data = new int[m + 1];
        picking(n, m, data, picked, 0);
    }

    static void picking(int n, int m, int[] data, boolean[] picked, int cnt) {
        if (cnt == m) {
            for (int i = 1; i <= m; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!picked[i]) {
                picked[i] = true;
                data[cnt + 1] = i;
                picking(n, m, data, picked, cnt + 1);
                picked[i] = false;
            }
        }
    }
}
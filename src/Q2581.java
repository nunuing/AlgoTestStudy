import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[n + 1];
        check[0] = true;
        check[1] = true;
        for (int i = 2; i <= n/2; i++) {
            for (int j = 2; j * i <= n; j++) {
                check[i * j] = true;
            }
        }
        int minVal = n + 1;
        long sum = 0;

        for (int i = m; i <= n; i++) {
            if (!check[i]) {
                minVal = Math.min(minVal, i);
                sum += i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum + "\n" + minVal);
        }
    }
}

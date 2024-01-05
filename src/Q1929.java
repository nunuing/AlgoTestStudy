import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int i = 2;
        boolean[] isPrime = new boolean[n + 1];

        isPrime[0] = true;
        isPrime[1] = true;
        while (i <= n) {
            for (int k = i * 2; k <= n; k += i) {
                isPrime[k] = true;
            }
            i++;
        }

        for (int l = m; l <= n; l++) {
            if (!isPrime[l])
                System.out.println(l);
        }

    }
}

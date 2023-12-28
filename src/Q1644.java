import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n/2; i++) {
            for (int j = 2; i * j <= n; j++) {
                prime[i * j] = true;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!prime[i])
                primes.add(i);
        }

        int answer = 0;
        for (int i = 0; i < primes.size(); i++) {
            int temp = 0;
            for (int j = i; j < primes.size(); j++) {
                temp += primes.get(j);
                if (temp >= n)
                    break;
            }
            if (temp == n)
                answer++;
        }
        System.out.println(answer);
    }
}

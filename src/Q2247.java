import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long answer = 0;
        for (int i = 2; i <= n/2; i++) {
            answer += ((n / i) - 1) * i;
        }
        System.out.println(answer % 1000000);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = -1;
        while (n != 0) {
            n = Integer.parseInt(br.readLine());

            long answer = 1;

            for (int i = 2; i <= n; i++) {
                answer *= i;
            }
            System.out.println(answer);
        }
    }
}

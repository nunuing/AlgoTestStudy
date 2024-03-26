import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (gcd(num[i], num[i + 1]) == 1)
                continue;
            boolean check = false;
            for (int k = num[i] + 1; k < num[i + 1]; k++) {
                if (gcd(num[i], k) == 1 && gcd(k, num[i + 1]) == 1) {
                    check = true;
                    break;
                }
            }
            if (!check)
                answer += 2;
            else
                answer++;
        }

        System.out.println(answer);
    }
    static int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}

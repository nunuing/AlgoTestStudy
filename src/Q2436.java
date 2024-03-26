import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());
        long mul = (long) gcd * lcm; // == a*b
        int a = gcd;
        int b = lcm;
        for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
            if (mul % i == 0) {
                int tb = (int)(mul / i);
                if (gcd(i, tb) == gcd) {
                    if (a + b >= i + tb) {
                        a = i;
                        b = tb;
                    }
                }
            }
        }
        System.out.println(a + " " + b);
    }
    static long gcd(long a, long b) {
        while (a % b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}

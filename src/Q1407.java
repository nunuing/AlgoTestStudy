import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(cal(b) - cal(a - 1));
    }
    static long cal(long n) {
        long answer = n;
        for (long i = 2; i <= n; i *= 2) {
            answer += (n/i)*(i/2);
        }
        return answer;
    }
}

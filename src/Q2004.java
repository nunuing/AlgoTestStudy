import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int numTwo = getTwo(n) - getTwo(m) - getTwo(n - m);
        int numFive = getFive(n) - getFive(m) - getFive(n - m);

        System.out.println(Math.min(numFive, numTwo));
    }
    public static int getTwo(long n){
        int answer = 0;
        while (n >= 2){
            answer += n / 2;
            n /= 2;
        }
        return answer;
    }

    public static int getFive(long n){
        int answer = 0;
        while (n >= 5){
            answer += n / 5;
            n /= 5;
        }
        return answer;
    }
}

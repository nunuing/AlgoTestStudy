import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        long answer = (x + y) * w;

        if ((x + y) % 2 == 0) {
            answer = Math.min(answer, Math.max(x, y) * s);
        }
        else {
            answer = Math.min(answer, (Math.max(x, y) - 1) * s + w);
        }

        answer = Math.min(answer, (Math.min(x, y) * s) + Math.abs(x - y) * w);
        System.out.println(answer);
    }
}

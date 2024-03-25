import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int num = 1;
        while (num * num <= n) {
            answer++;
            num++;
        }
        System.out.println(answer);
    }
}

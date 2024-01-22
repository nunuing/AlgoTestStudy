import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int answer = 0;
        int sum = 0;
        while (true) {
            if (sum >= m) {
                sum -= numbers[left++];
            }
            else if (right == n)
                break;
            else {
                sum += numbers[right++];
            }

            if (sum == m)
                answer++;
        }
        System.out.println(answer);
    }
}

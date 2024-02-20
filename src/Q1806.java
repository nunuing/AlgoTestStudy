import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] inputs = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int str = 0;
        int end = 0;
        int total = 0;
        int answer = Integer.MAX_VALUE;
        while (str <= n && end <= n) {
            if (total < s) {
                total += inputs[end++];
            }
            else if (total >= s) {
                answer = Math.min(answer, end - str);
                total -= inputs[str++];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}

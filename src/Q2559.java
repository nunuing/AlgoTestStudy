import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temperature = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }
        int[] prefix = new int[n];
        prefix[0] = temperature[0];
        for (int i = 1; i < n; i++) {
            prefix[i] += (temperature[i] + prefix[i - 1]);
        }

        int answer = prefix[k - 1];
        for (int i = k; i < n; i++) {
            answer = Math.max(prefix[i] - prefix[i - k], answer);
        }

        System.out.println(answer);
    }
}

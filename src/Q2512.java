import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            sum += input[i];
        }

        int m = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(input);
        if (sum <= m) {
            System.out.println(input[n - 1]);
            return;
        }

        int limit = input[n - 1];
        while (true) {

        }
    }
}

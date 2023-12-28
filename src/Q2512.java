import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = -1;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        br.close();
        while (left <= right) {
            int mid = (left + right) / 2;
            long budget = 0;
            for (int i = 0; i < n; i++) {
                if (input[i] > mid)
                    budget += mid;
                else
                    budget += input[i];
            }
            if (budget <= m)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(right);
    }
}

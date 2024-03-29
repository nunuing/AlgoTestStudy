import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q22988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] essences = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            essences[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(essences);
        int left = 0;
        int right = n - 1;
        int cnt = 0;
        int rest = 0;
        while (left <= right) {
            if (essences[right] >= x) {
                cnt++;
                right--;
                continue;
            }

            long sum = essences[left] + essences[right];

            if (left == right) {
                rest++;
                break;
            }
            if (sum >= (double) x / 2) {
                cnt++;
                left++;
                right--;
            } else {
                rest++;
                left++;
            }
        }

        System.out.println(cnt + rest / 3);
    }
}

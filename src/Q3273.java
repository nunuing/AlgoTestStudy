import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);
        int left = 0;
        int right = n - 1;
        int cnt = 0;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                cnt++;
                left++;
            }
            else if (sum < target) {
                left++;
            }
            else
                right--;
        }
        System.out.println(cnt);
    }
}

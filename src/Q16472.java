import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] check = new int['z' - 'a' + 1];
        char[] input = br.readLine().toCharArray();

        int left = 0;
        int right = 0;
        int cnt = 0;
        int answer = 0;
        while (left <= right && right < input.length) {
            if (check[input[right] - 'a' ] == 0) {
                cnt++;
            }
            check[input[right] - 'a' ]++;

            while (cnt > n && left < right) {
                check[input[left] - 'a']--;
                if (check[input[left] - 'a'] == 0)
                    cnt--;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        System.out.println(answer);
    }
}

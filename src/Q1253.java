import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (true) {
                if (left == i)
                    left++;
                else if (right == i)
                    right--;

                if (left >= right)
                    break;

                if (input[left] + input[right] > input[i])
                    right--;
                else if (input[left] + input[right] < input[i])
                    left++;
                else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}

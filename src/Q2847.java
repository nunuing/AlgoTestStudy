import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n - 1; i > 0; i--){
            for (int j = i - 1; j >= 0; j--) {
                if (levels[i] <= levels[j]) {
                    int temp = (levels[j] - levels[i]) + 1;
                    levels[j] -= temp;
                    answer += temp;
                }
            }
        }
        System.out.println(answer);
    }
}

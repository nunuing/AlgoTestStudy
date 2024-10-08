import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers);
            boolean check = true;
            for (int i = 1; i < n; i++) {
                if (numbers[i].startsWith(numbers[i - 1])) {
                    check = false;
                    break;
                }
            }
            sb.append(check ? "YES" : "NO");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14568 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    if (a + b + c == n) {
                        if (a - b >= 2) {
                            if (a != 0 && b != 0 && c != 0) {
                                if (c % 2 == 0) {
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        br.close();

        int now = 1;
        int pos = 0;
        while (true) {
            char[] check = String.valueOf(now).toCharArray();
            for (int i = 0; i < check.length; i++) {
                if (input[pos] == check[i]) {
                    pos++;
                }
                if (pos == input.length) {
                    System.out.println(now);
                    return;
                }
            }
            now++;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int zero = 0, one = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '0')
                zero++;
            else
                one++;
        }

        zero /= 2;
        boolean[] check = new boolean[input.length];
        for (int i = 0; i < check.length; i++) {
            if (input[i] == '0' && zero > 0) {
                check[i] = true;
                zero--;
            }
        }

        one /= 2;
        for (int i = check.length - 1; i >= 0; i--) {
            if (input[i] == '1' && one > 0) {
                check[i] = true;
                one--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (check[i]) {
                sb.append(input[i]);
            }
        }
        System.out.println(sb);
    }
}

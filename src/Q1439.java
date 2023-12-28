import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int zero = 0;
        int one = 0;
        if (input[0] == '1')
            one++;
        else
            zero++;

        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] != input[i]) {
                if (input[i] == '0')
                    zero++;
                else
                    one++;
            }
        }
        System.out.println(Math.min(zero, one));
    }
}

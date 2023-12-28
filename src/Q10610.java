import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] numbers = new int[input.length];

        int total = 0;
        for (int i = 0; i < input.length; i++) {
            numbers[i] = input[i] - '0';
            total += numbers[i];
        }

        Arrays.sort(numbers);
        if (numbers[0] != 0 || total % 3 != 0) {
            System.out.println(-1);
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = numbers.length - 1; i >= 0; i--)
                sb.append(numbers[i]);

            System.out.println(sb);
        }


    }
}

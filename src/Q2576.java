import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[7];
        int minOdd = Integer.MAX_VALUE, sumOdd = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (numbers[i] % 2 == 1) {
                sumOdd += numbers[i];
                minOdd = minOdd <= numbers[i] ? minOdd : numbers[i];
            }
        }
        if (sumOdd == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sumOdd + "\n" + minOdd);
        }
    }
}
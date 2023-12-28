import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num1 = 0, num2 = 0;

        for (int i = 2; i <= n; i++) {
            int temp1 = i;
            while (temp1 % 2 == 0) {
                num1++;
                temp1 /= 2;
            }

            int temp2 = i;
            while (temp2 % 5 == 0) {
                num2++;
                temp2 /= 5;
            }
        }

        if (n == 0)
            System.out.println(0);
        else
            System.out.println(Math.min(num1, num2));
    }
}

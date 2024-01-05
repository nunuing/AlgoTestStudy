import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        br.close();

        long result = a * b * c;
        int[] answer = new int[10];
        while (result > 0) {
            int temp = (int) (result % 10);
            answer[temp]++;
            result /= 10;
        }
        for (int i = 0; i <= 9; i++) {
            System.out.println(answer[i]);
        }
    }
}

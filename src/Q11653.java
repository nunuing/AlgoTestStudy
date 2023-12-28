import java.io.*;

public class Q11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int i = 2;
        while (n > 1) {
            while (n % i == 0) {
                sb.append(i + "\n");
                n /= i;
            }
            i++;
        }

        System.out.println(sb);
    }
}

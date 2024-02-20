import java.io.*;

public class Q1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        zero[1] = 0;

        one[0] = 0;
        one[1] = 1;
        for (int i = 2; i < zero.length; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            bw.append(zero[n] + " " + one[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

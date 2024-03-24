import java.io.*;

public class Q1816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            long input = Long.parseLong(br.readLine());
            boolean check = true;
            for (int i = 2; i < 1000000; i++) {
                if (input % i == 0) {
                    check = false;
                    break;
                }
            }
            bw.append((check ? "YES" : "NO") + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

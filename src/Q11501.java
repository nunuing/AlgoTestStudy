import java.io.*;
import java.util.StringTokenizer;

public class Q11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] inputs = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            int max = inputs[n - 1];
            long answer = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (max >= inputs[i]) {
                    answer += (max - inputs[i]);
                }
                else {
                    max = inputs[i];
                }
            }
            bw.append(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

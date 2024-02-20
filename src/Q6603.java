import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q6603 {
    static int[] data, result;
    static boolean[] isPicked;
    static BufferedWriter bw;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        data = new int[14];
        result = new int[6];
        isPicked = new boolean[14];

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (n != 0) {

            boolean[] isPicked = new boolean[n];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(st.nextToken());
                isPicked[i] = false;
            }

            lottery(0, 0);
            bw.write("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }

        bw.flush();
        bw.close();
    }

    static void lottery(int str, int cnt) throws IOException {
        if (cnt == 6) {
            for (int i = 0; i < result.length; i++) {
                bw.append(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = str; i < n; i++) {
            if (!isPicked[i]) {
                result[cnt] = data[i];
                isPicked[i] = true;
                lottery(i + 1, cnt + 1);
                isPicked[i] = false;
            }
        }

    }
}

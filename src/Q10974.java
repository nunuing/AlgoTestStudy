import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10974 {
    static int n;
    static int[] result;
    static boolean[] picked;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        

        picked = new boolean[n + 1];
        result = new int[n];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        picking(0);
        bw.flush();
        bw.close();
    }

    static void picking(int cnt) throws IOException {
        if (cnt == n) {
            for (int i = 0; i < n; i++) {
                bw.append(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!picked[i]) {
                picked[i] = true;
                result[cnt] = i;
                picking(cnt + 1);
                picked[i] = false;
            }
        }
    }
}

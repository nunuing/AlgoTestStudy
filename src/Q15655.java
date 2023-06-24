import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15655 {
    static BufferedWriter bw;
    static int n, m;
    static int[] data, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        data = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        result = new int[m];
        picking(0, 0);

        bw.flush();
        bw.close();
    }

    static void picking(int cnt, int str) throws IOException {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.append(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = str; i < n; i++) {
            result[cnt] = data[i];
            picking(cnt + 1, i + 1);
        }
    }
}

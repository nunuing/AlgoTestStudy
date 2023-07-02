import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1765 {
    static char[] data, result;
    static boolean[] isPicked;
    static int l, c;
                      // {a, b, c, b, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z}
    static int[] moums = {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 };
    static int[] jaums = {0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        data = new char[c];
        int j = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != ' ') {
                data[j++] = input[i];
            }
        }
        Arrays.sort(data);

        result = new char[l];
        isPicked = new boolean[c];
        for (int i = 0; i < c; i++)
            isPicked[i] = false;

        picking(0, 0);

    }

    static void picking(int cnt, int now) {
        if (cnt == l) {
            int moum = 0, jaum = 0;
            for (int i = 0; i < l; i++) {
                moum += moums[result[i] - 'a'];
                jaum += jaums[result[i] - 'a'];
            }
            if (moum >= 1 && jaum >= 2) {
                for (int i = 0; i < l; i++) {
                    System.out.print(result[i]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = now; i < c; i++) {
            if (!isPicked[i]) {
                isPicked[i] = true;
                result[cnt] = data[i];
                picking(cnt + 1,i + 1);
                isPicked[i] = false;
            }
        }
    }
}
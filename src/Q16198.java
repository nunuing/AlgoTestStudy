import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16198 {
    static int[] w;
    static int n, answer = 0;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            w[i] = Integer.parseInt(st.nextToken());
        br.close();

        used = new boolean[n];
        dfs(0, 0);
        System.out.println(answer);
    }
    static void dfs(int depth, int energy) {
        if ((n - depth) == 2) {
            answer = answer >= energy ? answer : energy;
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            if (!used[i]) {
                int before;
                for (before = i - 1; before >= 0; before--){
                    if (!used[before])
                        break;
                }
                int after;
                for (after = i + 1; after < n; after++) {
                    if (!used[after])
                        break;
                }
                used[i] = true;
                dfs(depth + 1, energy + (w[before] * w[after]));
                used[i] = false;
            }
        }
    }
}

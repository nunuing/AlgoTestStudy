import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {
    static int n, k, answer;
    static int[][] stuff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        stuff = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = -1;
        recur(1, 0, 0);
        System.out.println(answer);
    }
    static void recur(int depth, int weight, int value) {
        answer = Math.max(answer, value);

        if (depth > n)
            return;

        if (weight + stuff[depth][0] <= k)
            recur(depth + 1, weight + stuff[depth][0], value + stuff[depth][1]);
        recur(depth + 1, weight, value);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q19942_2 {
    static int mp, mf, ms, mv, n, answer;
    static int[][] food;
    static String result = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        food = new int[n + 1][5];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
            food[i][2] = Integer.parseInt(st.nextToken());
            food[i][3] = Integer.parseInt(st.nextToken());
            food[i][4] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;
        recur(1, 0, 0, 0, 0, 0, "");
        if (result.isEmpty())
            System.out.println(-1);
        else {
            System.out.println(answer);
            System.out.println(result);
        }
    }

    static void recur(int depth, int p, int f, int s, int v, int price, String str) {
        if (p >= mp && f >= mf && s >= ms && v >= mv) {
            if (answer > price) {
                answer = price;
                result = str;
            }
        }

        if (depth > n)
            return;

        recur(depth + 1, p + food[depth][0], f + food[depth][1], s + food[depth][2], v + food[depth][3], price + food[depth][4], str + depth + " ");
        recur(depth + 1, p, f, s, v, price, str);
    }

}

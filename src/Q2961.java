import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2961 {
    static int n, answer;
    static int[][] food;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        food = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;
        recur(0, 1, 0, 0);
        System.out.println(answer);
    }
    static void recur(int depth, int s, int b, int choose) {
        if (choose != 0)
            answer = Math.min(answer, Math.abs(s - b));
        if (depth >= n)
            return;

        recur(depth + 1, s * food[depth][0], b + food[depth][1], choose + 1);
        recur(depth + 1, s, b, choose);
    }
}

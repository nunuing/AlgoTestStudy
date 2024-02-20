import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684 {
    static int[][] map;
    static int n, m, h, answer;
    static boolean done = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h + 1][n + 1];
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            map[first][second] = 1;
            map[first][second + 1] = 2;
        }
        br.close();

        answer = 0;
        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(1, 1, 0);
            if (done)
                break;
        }

        System.out.println(done ? answer : -1);
    }
    static void dfs(int v, int hori, int depth) {
        if (done)
            return;
        if (depth == answer) {
            if (travel()) {
                answer = depth;
                done = true;
            }
            return;
        }


        for (int i = hori; i <= h; i++) {
            for (int j = v; j < n; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(1, 1, depth + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }
    static boolean travel() {
        for (int i = 1; i <= n; i++) {
            int vertical = i;
            int horizon = 1;
            while (horizon <= h) {
                if (map[horizon][vertical] == 1)
                    vertical++;
                else if (map[horizon][vertical] == 2)
                    vertical--;

                horizon++;
            }

            if (vertical != i)
                return false;
        }
        return true;
    }
}

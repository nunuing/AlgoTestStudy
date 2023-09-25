import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15686 {
    static int[][] map;
    static int n, m, answer;
    static List<Pair> house, chicken;
    static Pair[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Pair(j, i));
                } else if (map[i][j] == 2) {
                    chicken.add(new Pair(j, i));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        result = new Pair[m];
        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int now) {
        if (depth > m)
            return;
        if (depth > chicken.size())
            return;
        if (depth > 0) {
            int total = 0;
            for (int i = 0; i < house.size(); i++) {
                Pair h = house.get(i);
                int min = n * n + 1;
                for (int j = 0; j < depth; j++) {
                    int temp = Math.abs(h.x - result[j].x) + Math.abs(h.y - result[j].y);
                    min = min < temp ? min : temp;
                }
                total += min;
            }
            answer = Math.min(total, answer);
            if (depth == m || depth == chicken.size())
                return;
        }

        for (int i = now; i < chicken.size(); i++) {
            Pair temp = chicken.get(i);
            result[depth] = new Pair(temp.x, temp.y);
            dfs(depth + 1, i + 1);
        }
    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

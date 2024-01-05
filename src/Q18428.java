import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q18428 {
    static int n;
    static char[][] map;
    static int[] result;
    static ArrayList<Integer> teachers;
    static boolean jud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        teachers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T')
                    teachers.add((i * n) + j);
            }
        }
        result = new int[3];
        jud = false;
        dfs(0, 0);
        if (jud) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static void dfs(int depth, int now) {
        if (depth == 3) {
            check();
            return;
        }
        for (int i = now; i < n * n; i++) {
            int ti = i / n;
            int tj = i % n;
            if (map[ti][tj] == 'X') {
                result[depth] = (ti * n) + tj;
                dfs(depth + 1, ti + 1);
            }

        }
    }

    static void check() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int p : result) {
            int px = p / n;
            int py = p % n;
            map[px][py] = 'O';
        }
        for (int p : teachers) {
            int px = p / n;
            int py = p % n;
            for (int i = 0; i < dx.length; i++) {
                int tx = px + dx[i];
                int ty = py + dy[i];
                while ((tx >= 0 && tx < n) && (ty >= 0 && ty < n)) {
                    if (map[tx][ty] == 'S') {       //감시 실패
                        for (int temp : result) {
                            int tempx = temp / n;
                            int tempy = temp % n;
                            map[tempx][tempy] = 'X';
                        }
                        return;
                    } else if (map[tx][ty] == 'O') {
                        break;
                    }
                    tx += dx[i];
                    ty += dy[i];
                }
            }
        }

        for (int p : result) {
            int px = p / n;
            int py = p % n;
            map[px][py] = 'X';
        }
        jud = true;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15685 {
    static boolean[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new boolean[101][101];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            travel(x, y, d, g);
        }

        int[] sx = {0, 1, 0, 1};
        int[] sy = {0, 0, 1, 1};
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                boolean check = true;
                for (int k = 0; k < sx.length; k++) {
                    if (!map[i + sy[k]][j + sx[k]]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static void travel (int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);
        for (int i = 1; i <= g; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }

        int[] mx = {1, 0, -1, 0};
        int[] my = {0, -1, 0, 1};
        map[y][x] = true;
        for (Integer dir  : list) {
            y += my[dir];
            x += mx[dir];
            map[y][x] = true;
        }
    }
}

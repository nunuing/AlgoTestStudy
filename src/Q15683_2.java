import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15683_2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, answer, save;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        List<CCTV> cctvs = new LinkedList<>();
        answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    answer++;
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }


        for (CCTV c : cctvs) {
            int x = c.x;
            int y = c.y;
            int d = c.d;

            int[][][] copy = new int[4][n][m];
            save = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < copy.length; j++) {
                    copy[j][i] = map[i].clone();
                }
            }

            int temp = 0;
            if (d == 1) {
                check(new int[]{x, y}, true, false, false, false, copy[temp], temp++);
                check(new int[]{x, y}, false, true, false, false, copy[temp], temp++);
                check(new int[]{x, y}, false, false, true, false, copy[temp], temp++);
                check(new int[]{x, y}, false, false, false, true, copy[temp], temp);
            }
            else if (d == 2) {
                check(new int[]{x, y}, true, false, true, false, copy[temp], temp++);
                check(new int[]{x, y}, false, true, false, true, copy[temp], temp);
            }
            else if (d == 3) {
                check(new int[]{x, y}, true, true, false, false, copy[temp], temp++);
                check(new int[]{x, y}, false, true, true, false, copy[temp], temp++);
                check(new int[]{x, y}, false, false, true, true, copy[temp], temp++);
                check(new int[]{x, y}, true, false, false, true, copy[temp], temp);
            }
            else if (d == 4) {
                check(new int[]{x, y}, true, true, true, false, copy[temp], temp++);
                check(new int[]{x, y}, true, true, false, true, copy[temp], temp++);
                check(new int[]{x, y}, true, false, true, true, copy[temp], temp++);
                check(new int[]{x, y}, false, true, true, true, copy[temp], temp);
            }
            else if (d == 5) {
                check(new int[]{x, y}, true, true, true, true, copy[temp], temp);
            }

            for (int i = 0; i < n; i++) {
                map[i] = copy[save][i].clone();
            }
        }

        System.out.println(answer);
    }

    static class CCTV {
        public int x;
        public int y;
        public int d;

        public CCTV(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static void check(int[] str, boolean left, boolean up, boolean right, boolean down, int[][] copy, int now) {
        if (left) {
            for (int tx = str[0], ty = str[1]; tx >= 0; tx--) {
                if (copy[tx][ty] == 6)
                    break;

                if (copy[tx][ty] == 0) {
                    copy[tx][ty] = -1;
                }
            }
        }
        if (right) {
            for (int tx = str[0], ty = str[1]; tx < n; tx++) {
                if (copy[tx][ty] == 6)
                    break;

                if (copy[tx][ty] == 0) {
                    copy[tx][ty] = -1;
                }
            }
        }
        if (up) {
            for (int tx = str[0], ty = str[1]; ty >= 0; ty--) {
                if (copy[tx][ty] == 6)
                    break;

                if (copy[tx][ty] == 0) {
                    copy[tx][ty] = -1;
                }
            }
        }

        if (down) {
            for (int tx = str[0], ty = str[1]; ty < m; ty++) {
                if (copy[tx][ty] == 6)
                    break;

                if (copy[tx][ty] == 0) {
                    copy[tx][ty] = -1;
                }
            }
        }

        int tc = count(copy);
        if (answer > tc) {
            save = now;
            answer = tc;
        }
    }
    static int count(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}


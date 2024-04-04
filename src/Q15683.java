import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q15683 {
    static LinkedList<Pair>[] list;
    static int n, m, cnt;
    static int[][] map;
    static boolean[][] visible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        list = new LinkedList[9];
        visible = new boolean[n][m];
        for (int i = 0; i < list.length; i++)
            list[i] = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                list[map[i][j]].add(new Pair(i, j));
            }
        }

        cnt = list[0].size();
        for (int i = 5; i > 0; i--){
            for (Pair p : list[i]) {
                cctv(i, p);
            }
        }

        System.out.println(cnt);
    }
    static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void cctv(int num, Pair pos) {
        if (num == 5) {
            visible = check(true, true, true, true, pos, visible);
            cnt -= count(visible);
        }
        else if (num == 4) {
            boolean[][][] copy = new boolean[4][n][m];
            copy[0] = check(true, true, true, false, pos, visible);
            copy[1] = check(true, true, false, true, pos, visible);
            copy[2] = check(true, false, true, true, pos, visible);
            copy[3] = check(false, true, true, true, pos, visible);

            visible = copy[0];
            int max = count(visible);
            for (int i = 1; i < 4; i++) {
                int temp = count(copy[i]);
                if (max < temp) {

                }
            }
        }
        else if (num == 3) {
            boolean[][] c1 = check(true, true, false, false, pos, visible);
            int n1 = count(c1);
            boolean[][] c2 = check(false, true, true, false, pos, visible);
            int n2 = count(c2);
            boolean[][] c3 = check(false, false, true, true, pos, visible);
            int n3 = count(c3);
            boolean[][] c4 = check(true, false, false, true, pos, visible);
            int n4 = count(c4);
        }
        else if (num == 2) {
            boolean[][] c1 = check(true, false, true, false, pos, visible);
            int n1 = count(c1);
            boolean[][] c2 = check(false, true, false, true, pos, visible);
            int n2 = count(c2);
        }
        else if(num == 1){
            boolean[][] c1 = check(true, false, false, false, pos, visible);
            int n1 = count(c1);
            boolean[][] c2 = check(false, true, false, false, pos, visible);
            int n2 = count(c2);
            boolean[][] c3 = check(false, false, true, false, pos, visible);
            int n3 = count(c3);
            boolean[][] c4 = check(false, false, false, true, pos, visible);
            int n4 = count(c4);
        }
    }
    static boolean[][] check(boolean up, boolean down, boolean left, boolean right, Pair pos, boolean[][] copy) {
        int tc = 0;
        if (up){
            int tx = pos.x;
            int ty = pos.y;
            while (ty-- >= 0) {
                if (map[tx][ty] == 1)
                    break;
                if (!copy[tx][ty]) {
                    copy[tx][ty] = true;
                    tc++;
                }
            }
        }
        if (down) {
            int tx = pos.x;
            int ty = pos.y;
            while (ty++ < m) {
                if (map[tx][ty] == 1)
                    break;
                if (!copy[tx][ty]) {
                    copy[tx][ty] = true;
                    tc++;
                }
            }
        }
        if (left) {
            int tx = pos.x;
            int ty = pos.y;
            while (tx-- >= 0) {
                if (map[tx][ty]== 1)
                    break;
                if (!copy[tx][ty]){
                    copy[tx][ty] = true;
                    tc++;
                }
            }
        }
        if (right) {
            int tx = pos.x;
            int ty = pos.y;
            while (tx++ < n) {
                if (map[tx][ty] == 1)
                    break;
                if (!copy[tx][ty]) {
                    copy[tx][ty] = true;
                    tc++;
                }
            }
        }
        return copy;
    }
    static int count(boolean[][] copy){
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

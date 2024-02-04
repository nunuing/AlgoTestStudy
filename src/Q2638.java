import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2638 {
    static int n, m;
    static boolean[][] cheese;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheese = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int time = 1;
        while (true) {
            ArrayList<int[]> list = new ArrayList<>();
            boolean flag = false;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++){
                    if (cheese[i][j]) {
                        flag = true;
                        if (check(i, j)) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }

            if (!flag)
                break;

            for (int[] melt : list) {
                cheese[melt[0]][melt[1]] = false;
            }
            time++;
        }
        System.out.println(time);
    }
    static boolean check(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            boolean flag = true;
            while (tx >= 0 && tx < n && ty >= 0 && ty < m){
                if(cheese[tx][ty]) {
                    flag = false;
                    break;
                }
                tx += dx[i];
                ty += dy[i];
            }
            if (flag)
                cnt++;
        }
        if (cnt >= 2)
            return true;
        return false;
    }
}

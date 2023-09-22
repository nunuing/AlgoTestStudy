import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[101][101];

        StringTokenizer st;
        int[] mx = {}
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

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
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int p1x = -1;
        int p1y = -1;
        int p2x = -1;
        int p2y = -1;

        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (p1y == -1 && p1x == -1) {
                        p1x = i;
                        p1y = j;
                    }
                    else {
                        p2x = i;
                        p2y = j;
                    }
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (t-- > 0) {
            int[][] cmap = new int[r][c];
            // 미세 먼지 확산
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] <= 0)
                        continue;
                    int temp = 0;
                    int dust = map[i][j] / 5;
                    for (int k = 0; k < dx.length; k++){
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (tx < 0 || tx >= r || ty < 0 || ty >= c) continue;

                        if (map[tx][ty] == -1)
                            continue;

                        cmap[tx][ty] += dust;
                        temp += dust;
                    }

                    cmap[i][j] -= temp;
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] += cmap[i][j];
                }
            }

            map[p1x][p1y] = 0;
            map[p2x][p2y] = 0;
            //공기청정기 가동 - 반시계방향 회전
            for (int i = p1x - 1; i > 0; i--) {
                map[i][0] = map[i - 1][0];
            }
            for (int i = 0; i < c - 1; i++) {
                map[0][i] = map[0][i + 1];
            }
            for (int i = 0; i < p1x ; i++) {
                map[i][c - 1] = map[i + 1][c - 1];
            }
            for (int i = c - 1; i > 0; i--) {
                map[p1x][i] = map[p1x][i - 1];
            }

            //시계방향 회전
            for (int i = p2x + 1; i < r - 1; i++) {
                map[i][0] = map[i + 1][0];
            }
            for (int i = 0; i < c - 1; i++) {
                map[r - 1][i] = map[r - 1][i + 1];
            }
            for (int i = r - 1; i > p2x; i--) {
                map[i][c - 1] = map[i - 1][c - 1];
            }
            for (int i = c - 1; i > 0; i--) {
                map[p2x][i] = map[p2x][i - 1];
            }
            map[p1x][p1y] = -1;
            map[p2x][p2y] = -1;
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer + 2);
    }
}
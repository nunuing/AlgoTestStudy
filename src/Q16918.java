import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        int[][] time = new int[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    time[i][j] = 0;
                }
                else {
                    time[i][j] = -1;
                }
            }
        }
        br.close();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        int sec = 1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sec++ < n) {
            //폭탄 설치하기 -> 짝수 초마다
            if (sec % 2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            time[i][j] = sec;
                        }
                    }
                }
            }
            else {
                //폭탄 터짐 -> 홀수 초마다
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (map[i][j] == 'O' && time[i][j] == sec - 3) {
                            queue.offer(new int[]{i, j});
                        }
                    }
                }
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    map[now[0]][now[1]] = '.';
                    time[now[0]][now[1]] = -1;
                    for (int i = 0; i < dx.length; i++) {
                        int tx = now[0] + dx[i];
                        int ty = now[1] + dy[i];

                        if (tx < 0 || tx >= r || ty < 0 || ty >= c)
                            continue;
                        map[tx][ty] = '.';
                        time[tx][ty] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.append(map[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17143 {
    public static void main(String[] args) throws IOException {
        //낚시왕 오른쪽 한칸 이동
        // 낚시 왕이 잡은 상어 크기의 합을 구해자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sea = new int[r + 1][c + 1];
        Shark[] sharks = new Shark[m + 1];
        boolean[] caught = new boolean[m + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int tr = Integer.parseInt(st.nextToken());
            int tc = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int td = Integer.parseInt(st.nextToken());
            int ts = Integer.parseInt(st.nextToken());

            if (td == 1) {
                td = 2;
            }
            else if (td == 2) {
                td = 0;
            }
            else if (td == 3) {
                td = 1;
            }
            else {
                td = 3;
            }

            sharks[i] = new Shark(tr, tc, tv, td, ts);
            sea[tr][tc] = i;
        }

        int king = 1;
        int answer = 0;
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        while (king <= c) {
            //낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다
            for (int i = 1; i <= r; i++) {
                if (sea[i][king] != 0) {
                    int stemp = sea[i][king];
                    if (caught[stemp])
                        continue;
                    answer += sharks[sea[i][king]].size;
                    //상어를 잡으면 격자판에서 잡은 상어가 사라진다
                    sea[i][king] = 0;
                    caught[stemp] = true;
                    break;
                }
            }
            //상어가 이동한다 -> 입력으로 주어진 속도로 이동, 상어가 이동하려는 칸이 격자판의 경계를 넘는 경우 방향을 반대로 바꿔서 이동
            sea = new int[r + 1][c + 1];
            for (int i = 1; i <= m; i++) {
                if (caught[i])
                    continue;
                Shark moving = sharks[i];
                int speed = moving.velocity;
                if (moving.direction % 2 == 0) {
                    speed %= (r - 1) * 2;
                }
                else {
                    speed %= (c - 1) * 2;
                }
                for (int p = 0; p < speed; p++) {
                    int nr = moving.r + dr[moving.direction];
                    int nc = moving.c + dc[moving.direction];
                    if (nr <= 0 || nr > r || nc <= 0 || nc > c) {
                        moving.r -= dr[moving.direction];
                        moving.c -= dc[moving.direction];
                        moving.direction = (moving.direction + 2) % 4;
                        continue;
                    }
                    moving.r = nr;
                    moving.c = nc;
                }

                if (sea[moving.r][moving.c] != 0) {
                    int cs = sea[moving.r][moving.c];
                    if (sharks[cs].size < moving.size) {
                        caught[cs] = true;
                        sea[moving.r][moving.c] = i;
                    }
                    else if (sharks[cs].size > moving.size) {
                        caught[i] = true;
                    }
                }
                else {
                    sea[moving.r][moving.c] = i;
                }
            }
            king++;
        }
        System.out.println(answer);
    }
    static class Shark {
        public int r;
        public int c;
        public int velocity;
        public int size;
        public int direction;
        public Shark(int r, int c, int velocity, int direction, int size) {
            this.r = r;
            this.c = c;
            this.velocity = velocity;
            this.size = size;
            this.direction = direction;
        }
    }
}

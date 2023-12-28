import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        int screen = 1;
        int clip = 0;
        int time = 0;
        Step now = new Step(time, screen, clip);

        boolean[][] visited = new boolean[1001][1001];

        Queue<Step> queue = new LinkedList<>();
        queue.offer(now);
        visited[now.screen][now.clip] = true;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.screen == s) {
                System.out.println(now.time);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {                   //복사
                    screen = now.screen;
                    clip = now.screen;
                } else if (i == 1) {            //붙여넣기
                    if (now.clip == 0)
                        continue;
                    screen = now.screen + now.clip;
                    clip = now.clip;
                } else if (i == 2) {            //이모티콘 삭제
                    if (now.screen < 1)
                        continue;
                    screen = now.screen - 1;
                    clip = now.clip;
                }

                if ((screen < 0 || screen >= visited.length) || (clip < 0 || clip >= visited.length))
                    continue;

                if (!visited[screen][clip]) {
                    queue.offer(new Step(now.time + 1, screen, clip));
                    visited[screen][clip] = true;
                }
            }
        }
    }

    static class Step {
        public int time;
        public int screen;
        public int clip;

        public Step(int time, int screen, int clip) {
            this.time = time;
            this.screen = screen;
            this.clip = clip;
        }
    }
}

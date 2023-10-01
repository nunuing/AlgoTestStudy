import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q21609 {
    static int[][] group, map;
    static int n;
    static PriorityQueue<Group> groups = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        group = new int[n][n];
        int g_cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] == 0 && map[i][j] != -1 && map[i][j] != 0) {
                    grouping(g_cnt++, new Pair(j, i));
                }
            }
        }

        int score = 0;
        while (!groups.isEmpty()) {
            Group now = groups.poll();
            score += (now.cnt * now.cnt);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (group[i][j] == now.num) {
                        group[i][j] = 0;
                        map[i][j] = -2;
                    }
                }
            }
            //이동
            for (int i = n - 1; i > 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (group[i][j] == 0 && map[i][j] == -2) {

                    }
                }
            }
            //중력

        }
        System.out.println(score);
    }
    static void grouping (int num, Pair str) {
        Queue<Pair> q = new LinkedList<>();

        group[str.y][str.x] = num;
        q.offer(str);

        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};

        int color = map[str.y][str.x];
        int rainbow = 0;
        int normal = 1;
        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                    continue;

                if (group[ty][tx] == 0 && (map[ty][tx] == color || map[ty][tx] == 0)) {
                    group[ty][tx] = num;
                    q.offer(new Pair(tx, ty));
                    if (map[ty][tx] == 0)
                        rainbow++;
                    else
                        normal++;
                }
            }
        }

        if (normal >= 1 && rainbow + normal >= 2) {
            groups.offer(new Group(num, color, normal + rainbow, rainbow, str));
        }
    }
    static class Group implements Comparable<Group> {
        public int num;
        public int color;
        public int cnt;
        public int rainbow;
        public Pair mark;
        public Group(int num, int color, int cnt, int rainbow, Pair mark) {
            this.num = num;
            this.color = color;
            this.cnt = cnt;
            this.rainbow = rainbow;
            this.mark = mark;
        }

        @Override
        public int compareTo(Group o) {
            if (this.cnt != o.cnt)
            return Integer.compare(o.cnt, this.cnt);

            if (this.rainbow != o.rainbow)
                return Integer.compare(o.rainbow, this.rainbow);

            if (this.mark.y != o.mark.y)
                return Integer.compare(o.mark.y, this.mark.y);

            return Integer.compare(o.mark.x, this.mark.x);
        }
    }
    static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

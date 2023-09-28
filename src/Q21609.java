import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21609 {
    static int[][] group, map;
    static int n;
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
    }
    static void grouping (int num, Pair str) {
        Queue<Pair> q = new LinkedList<>();

        group[str.y][str.x] = num;
        q.offer(str);

        int[] mx = {-1, 1, 0, 0};
        int[] my = {0, 0, -1, 1};

        int color = map[str.y][str.x];
        int rainbow = 0;
        int cnt = 1;
        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (int i = 0; i < mx.length; i++) {
                int tx = now.x + mx[i];
                int ty = now.y + my[i];

                if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                    continue;

                if (group[ty][tx] == 0 && (map[ty][tx] == color || map[ty][tx] == 0)) {
                    group[ty][tx] = num;
                    cnt++;
                    if (map[ty][tx] == 0)
                        rainbow++;
                }
            }
        }
    }
    static class Group implements Comparator<Group> {
        public int color;
        public int cnt;
        public int rainbow;
        public Pair mark;
        public Group(int color, int cnt, int rainbow, Pair mark) {
            this.color = color;
            this.cnt = cnt;
            this.rainbow = rainbow;
            this.mark = mark;
        }

        @Override
        public int compare(Group o1, Group o2) {
            if (o1.cnt != o2.cnt)
                return Integer.compare(o2.cnt, o1.cnt);

            if (o1.rainbow != o2.rainbow)
                return Integer.compare(o2.rainbow,o1.rainbow);

            if (o1.mark.y != o2.mark.y)
                return Integer.compare(o2.mark.y, o2.mark.y);

            return Integer.compare(o2.mark.x, o1.mark.x);
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        char[][] map = new char[h][w];
        Pair str = null;
        Pair dest = null;
        for (int i = 0; i < h; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (temp[j] == 'C' && str == null)
                    str = new Pair(i, j);
                else if (temp[j] == 'C' && str != null)
                    dest = new Pair(i, j);
                map[i][j] = temp[j];
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Pair> Queue = new LinkedList<>();

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

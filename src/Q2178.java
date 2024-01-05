import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j] == '1' ? true : false;
            }
        }


        int[] mx = {0, 0, -1, 1};
        int[] my = {-1, 1, 0, 0};

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));

        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        while (!queue.isEmpty()){
            Pair now = queue.poll();
            if(now.x == n - 1 && now.y == m - 1)
                break;

            for(int i = 0; i < mx.length; i++){
                int dx = now.x + mx[i];
                int dy = now.y + my[i];
                if((dx >= 0 && dx < n) && (dy >= 0 && dy < m)){
                    if(visited[dx][dy] == 0 && map[dx][dy]){
                        visited[dx][dy] = visited[now.x][now.y] + 1;
                        queue.offer(new Pair(dx, dy));
                    }
                }
            }
        }

        System.out.println(visited[n - 1][m - 1]);
    }
    static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

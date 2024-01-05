import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] tomatoes = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 1){
                    queue.add(new Pair(i, j));
                }
            }
        }
        int level = 1;
        int[] mx = {0, 0, -1, 1};
        int[] my = {-1, 1, 0, 0};

        Pair now;
        while (!queue.isEmpty()){
            now = queue.poll();
            for (int i = 0; i < mx.length; i++){
                int dx = now.x + mx[i];
                int dy = now.y + my[i];

                if((dx >= 0 && dx < m) && (dy >= 0 && dy < n)){
                    if(tomatoes[dx][dy] == 0){
                        tomatoes[dx][dy] = tomatoes[now.x][now.y] + 1;
                        level = tomatoes[dx][dy] > level ? tomatoes[dx][dy] : level;
                        queue.add(new Pair(dx, dy));
                    }
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(tomatoes[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(level - 1);
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

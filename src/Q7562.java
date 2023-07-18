import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        while (tc -- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Pair str = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Pair dest = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int[] mx = {-2, -1, 1, 2, 2, 1, -1, -2};
            int[] my = {-1, -2, -2, -1, 1, 2, 2, 1};
            for(int i = 0; i < n; i++)
                Arrays.fill(board[i], n * n);

            Queue<Pair> queue = new LinkedList<>();
            board[str.x][str.y] = 0;
            queue.add(str);
            while (!queue.isEmpty()){
                Pair now = queue.poll();

                for(int i = 0; i < mx.length; i++){
                    int dx = now.x + mx[i];
                    int dy = now.y + my[i];
                    if((dx >= 0 && dx < n) && (dy >= 0 && dy < n)){
                        if(board[dx][dy] == n * n) {
                            board[dx][dy] = board[dx][dy] <= board[now.x][now.y] + 1 ? board[dx][dy] : board[now.x][now.y] + 1;
                            queue.add(new Pair(dx, dy));
                        }
                    }
                }
            }
            bw.append(board[dest.x][dest.y] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
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

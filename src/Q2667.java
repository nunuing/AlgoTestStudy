import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Q2667 {
    static int[][] map;
    static int[][] visited;
    static int n, cnt;
    static PriorityQueue<Integer> apt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new int[n][n];
        for(int i = 0; i < n; i++){
            char[] input = br.readLine().toCharArray();
            Arrays.fill(visited[i], -1);
            for(int j = 0; j < n; j++){
                map[i][j] = input[j] - '0';
            }
        }
        cnt = 0;
        apt = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && visited[i][j] < 0){
                    Pair str = new Pair(i, j);
                    travel(str);
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(cnt + "\n");
        while (!apt.isEmpty()){
            bw.append(apt.poll() + "\n");
        }
        bw.flush();
        bw.close();

        br.close();
    }
    static void travel(Pair now){
        int[] dx = {0,  0, -1, 1};
        int[] dy = {-1, 1,  0, 0};

        Stack<Pair> stack = new Stack<>();
        stack.push(now);
        int n_cnt = cnt++;
        int temp = 0;
        while (!stack.empty()){
            now = stack.pop();
            if(visited[now.x][now.y] >= 0){
                continue;
            }
            visited[now.x][now.y] = n_cnt;
            temp++;
            for(int i = 0; i < 4; i++){
                int tempX = now.x + dx[i];
                int tempY = now.y + dy[i];
                if((tempX >= 0 && tempX < n) && (tempY >= 0 && tempY < n)){
                    if(visited[tempX][tempY] < 0 && map[tempX][tempY] == 1){
                        stack.push(new Pair(tempX, tempY));
                    }
                }
            }
        }
        apt.add(temp);
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

import java.io.*;
import java.util.*;

public class Q4963 {
    static boolean[][] map, visited;
    static int w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }
            map = new boolean[h][w];
            visited = new boolean[h][w];
            for(int i = 0; i < map.length; i++){
                Arrays.fill(visited[i], false);
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < map[0].length; j++){
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }
            int cnt = 0;
            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[0].length; j++){
                    if(!visited[i][j] && map[i][j]){
                        cnt++;
                        travel(new Pair(i, j));
                    }
                }
            }
            bw.append(cnt + "\n");
        }
        bw.flush();
        bw.close();

        br.close();
    }
    static void travel(Pair now){
        Stack<Pair> stack = new Stack<>();
        stack.push(now);

        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

        while (!stack.empty()){
            now = stack.pop();
            if(visited[now.x][now.y])
                continue;
            visited[now.x][now.y] = true;
            for(int i = 0; i < dx.length; i++){
                int tempX = now.x + dx[i];
                int tempY = now.y + dy[i];
                if((tempX >= 0 && tempX < map.length) && (tempY >= 0  && tempY < map[0].length)){
                    if(!visited[tempX][tempY] && map[tempX][tempY])
                        stack.add(new Pair(tempX, tempY));
                }
            }
        }
    }
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

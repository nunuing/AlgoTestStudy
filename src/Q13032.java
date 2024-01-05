import java.io.*;
import java.util.*;

public class Q13032 {
    static int n, m;
    static LinkedList<Integer>[] friendship;
    static  boolean[] visited;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        friendship = new LinkedList[n];
        for(int i = 0; i < n; i++){
            friendship[i] = new LinkedList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            friendship[str].add(dest);
            friendship[dest].add(str);
        }

        visited = new boolean[n];
        Arrays.fill(visited, false);
        result = false;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            if(!result) {
                dfs(1, i);
            }
            else {
                break;
            }
        }
        bw.append(result ? "1" : "0");
        bw.flush();
        bw.close();
    }
    static void dfs(int cnt, int now){
        if(cnt == 5){
            result = true;
            return;
        }
        visited[now] = true;
        for(int pos : friendship[now]){
            if(!visited[pos]){
                dfs(cnt + 1, pos);
            }
            if(result){
                return;
            }
        }
        visited[now] = false;
    }
}

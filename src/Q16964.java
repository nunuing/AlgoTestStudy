import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q16964 {
    static int n;
    static LinkedList<Integer>[] map;
    static int[] visited;
    static int[] load;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first].add(second);
            map[second].add(first);
        }

        st = new StringTokenizer(br.readLine());
        load = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            load[i] = Integer.parseInt(st.nextToken());
        }
        if(load[1] != 1){
            System.out.println("0");
            return;
        }

        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;

        if(dfs(1, 1))
            System.out.println(1);
        else
            System.out.println(0);
    }
    static boolean dfs(int now, int index){
        int cnt = 0;
        for (int v : map[now]){
            if(visited[v] == -1){
                visited[v] = now;
                cnt++;
            }
        }

        index++;
        for (int i = 0; i < cnt; i++){
            int child = load[index];
            if(visited[child] != now){
                return false;
            }
            if(!dfs(child, index))
                return false;
        }
        return true;
    }
}


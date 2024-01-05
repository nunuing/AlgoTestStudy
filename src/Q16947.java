import java.io.*;
import java.util.*;

public class Q16947 {
    static int n;
    static LinkedList<Integer>[] subway;
    static boolean[] inCircle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        subway = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            subway[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            subway[first].add(second);
            subway[second].add(first);
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            inCircle = new boolean[n + 1];
            if (findCircle(i, -1, i))
                break;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= n; i++){
            int level = bfs(i);
            bw.append(level + " ");
        }
        bw.flush();
        bw.close();
    }
    static boolean findCircle(int now, int parent, int start) {
        inCircle[now] = true;
        for (int pos : subway[now]) {
            if (!inCircle[pos]) {
                if (findCircle(pos, now, start)) {
                    return true;
                }
            } else if (pos != parent && pos == start){
                return true;
            }
        }
        inCircle[now] = false;
        return false;
    }
    static int bfs(int str){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];

        queue.add(str);
        while (!queue.isEmpty()){
            int now = queue.poll();
            if(inCircle[now]){
                return visited[now];
            }
            for (int v : subway[now]){
                if(visited[v] == 0){
                    visited[v] = visited[now] + 1;
                    queue.add(v);
                }
            }
        }
        return 0;
    }
}
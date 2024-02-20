import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] map = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new LinkedList<>();

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first].add(second);
            map[second].add(first);
        }

        int[] load = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            load[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        if(load[1] != 1){
            System.out.println("0");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int now = 1;
        int cnt = 2;
        visited[now] = true;

        queue.offer(now);
        while (!queue.isEmpty()) {
            now = queue.poll();
            int child = 0;
            for (int v : map[now]){
                if(!visited[v]){
                    visited[v] = true;
                    child++;
                }
            }

            for (int i = cnt; i < cnt + child; i++) {
                if (!visited[load[i]]) {
                    System.out.println("0");
                    return;
                }
                else {
                    queue.offer(load[i]);
                }
            }
            cnt += child;
        }

        System.out.println("1");
    }
}

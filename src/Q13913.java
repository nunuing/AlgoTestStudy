import java.io.*;
import java.util.*;

public class Q13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        br.close();

        Queue<Integer> queue = new LinkedList<>();

        int[] visited = new int[100001];
        int[] load = new int[100001];

        Arrays.fill(load, -1);
        Arrays.fill(visited, -1);

        int now = n;
        queue.offer(now);
        load[now] = -2;
        visited[now] = 0;

        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now == k){
                break;
            }

            for (int i = 0; i < 3; i++) {
                int temp = now + 1;
                if (i == 1)
                    temp = now - 1;
                else if (i == 2)
                    temp = now * 2;

                if (temp >= 0 && temp <= 100000) {
                    if(visited[temp] == -1){
                        load[temp] = now;
                        visited[temp] = visited[now] + 1;
                        queue.offer(temp);
                    }
                }
            }
        }

        int cnt = 0;
        while (cnt <= visited[k]){
            sb.insert(0, now + " ");
            now = load[now];
            cnt++;
        }

        sb.insert(0, visited[k] + "\n");
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        br.close();

        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();

        int now = n;
        queue.offer(n);
        visited[now] = 0;

        while (!queue.isEmpty()) {
            now = queue.poll();

            for (int i = 0;  i < 3; i++){
                int temp = now * 2;
                if(i == 1)
                    temp = now + 1;
                else if (i == 2)
                    temp = now - 1;

                if(temp < 0 || temp > 100000)
                    continue;

                if(visited[temp] == -1){
                    if(i != 0)
                        visited[temp] = visited[now] + 1;
                    else
                        visited[temp] = visited[now];

                    queue.offer(temp);
                }
                else{
                    if(i == 0  && visited[temp] > visited[now]){
                        visited[temp] = visited[now];
                        queue.offer(temp);
                    }
                    else if(i != 0 && visited[temp] > visited[now] + 1) {
                        visited[temp] = visited[now] + 1;
                        queue.offer(temp);
                    }
                }
            }
        }
        System.out.println(visited[k]);
    }
}

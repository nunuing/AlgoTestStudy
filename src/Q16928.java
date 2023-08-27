import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        Arrays.fill(map, 0);

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            map[str] = dest;
        }
        br.close();

        int[] visited = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, -1);

        int now = 1;
        queue.offer(now);
        visited[now] = 0;
        
        while (!queue.isEmpty()) {
            now = queue.poll();

            if (now == 100)
                break;

            int temp = visited[now] + 1;
            for (int i = 1; i <= 6; i++) {
                int tPos = now + i;

                if (tPos < 0 || tPos > 100)
                    continue;

                if (map[tPos] != 0)
                    tPos = map[tPos];

                if (visited[tPos] == -1) {
                    queue.offer(tPos);
                    visited[tPos] = temp;
                }
            }
        }
        System.out.println(visited[100]);
    }
}

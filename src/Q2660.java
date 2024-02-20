import java.io.*;
import java.util.*;

public class Q2660 {
    static int n;
    static ArrayList<Integer>[] friendships, scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        friendships = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            friendships[i] = new ArrayList<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (s == -1 && d == -1) {
                break;
            }

            friendships[s].add(d);
            friendships[d].add(s);
        }

        scores = new ArrayList[51];
        for (int i = 1; i <= 50; i++)
            scores[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (scores[i].size() > 0) {
                bw.append(i + " " + scores[i].size() + "\n");
                for (int temp : scores[i])
                    bw.append(temp + " ");
                bw.newLine();
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(int now) {
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(now);
        visited[now] = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int dist = visited[cur];
            for (int next : friendships[cur]) {
                if(visited[next] == -1) {
                    visited[next] = dist + 1;
                    max = max > dist + 1 ? max : dist + 1;
                    queue.offer(next);
                }
            }
        }
        scores[max].add(now);
    }
}

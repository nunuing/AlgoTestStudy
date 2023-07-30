import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1167 {
    static int v, maxDist, farNode;
    static LinkedList<Node>[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());
        map = new LinkedList[v + 1];
        for(int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            map[num] = new LinkedList<>();
            while (dest != -1) {
                int dist = Integer.parseInt(st.nextToken());
                map[num].add(new Node(dest, dist));

                dest = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[v + 1];
        maxDist = 0;
        farNode = 0;
        dfs(1, 0);

        Arrays.fill(visited, false);
        dfs(farNode, 0);

        System.out.println(maxDist);
        br.close();
    }
    static void dfs(int now, int dist) {
        if (maxDist < dist) {
            maxDist = dist;
            farNode = now;
        }
        visited[now] = true;
        for (Node n : map[now]) {
            if (!visited[n.num]) {
                dfs(n.num, dist + n.dist);
            }
        }
    }
    static class Node {
        public int num;
        public int dist;
        public Node (int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}

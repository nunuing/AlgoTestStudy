import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1967 {
    static LinkedList<Node>[] map;
    static boolean[] visited;
    static int mDist, farNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            map[i] = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[str].add(new Node(dest, dist));
            map[dest].add(new Node(str, dist));
        }

        visited = new boolean[n + 1];
        mDist = 0;
        farNode = 1;
        dfs(1, 0);

        Arrays.fill(visited, false);
        dfs(farNode, 0);

        System.out.println(mDist);
    }
    static void dfs(int now, int dist) {
        if (mDist <= dist) {
            mDist = dist;
            farNode = now;
        }
        visited[now] = true;
        for (Node n : map[now]) {
            if (!visited[n.num]){
                dfs(n.num, dist + n.dist);
            }
        }
    }
    static class Node {
        public int num;
        public int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1135 {
    static int n;
    static ArrayList<Integer>[] child;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        child = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (i != 0)
                child[p].add(i);
        }
        dp = new int[n];
        System.out.println(dfs(0));
    }
    static int dfs(int cur) {
        int cnt = 0;
        int max = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] -o1[1]);
        for (Integer next : child[cur]) {
            dp[next] = dfs(next);
            queue.add(new int[]{next, dp[next]});
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            cnt++;
            max = Math.max(max, node[1] + cnt);
        }
        return max;
    }

}

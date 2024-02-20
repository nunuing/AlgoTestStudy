import java.util.Arrays;

public class P37 {
    static int[] parents;
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}));
    }
    static public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, ((o1, o2) -> o1[2] - o2[2]));

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : costs) {
            int str = edge[0];
            int dest = edge[1];
            int cost = edge[2];

            int strParent = findParent(str);
            int destParent = findParent(dest);

            if (strParent == destParent)
                continue;

            answer += cost;
            parents[destParent] = strParent;
        }


        return answer;
    }
    static int findParent(int node) {
        if (parents[node] == node)
            return node;
        return parents[node] = findParent(parents[node]);
    }
}

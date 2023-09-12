import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P7 {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        System.out.println(solution(6,4,6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(solution(7,3,4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(solution(6,4,5, 6, new int[][]{{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}}));
    }
    static public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[] distA = new int[n + 1];
        Arrays.fill(distA, INF);
        int[] parentA = new int[n + 1];

        int now = s;
        distA[now] = 0;
        while (now != a) {

            for (int i = 1;  i <= n; i++) {
                if (fares[now][i] != 0) {
                    int temp = distA[now] + fares[now][i];
                    if (distA[now] + fares[now][i] < distA[i]) {
                        distA[i] = temp;
                        parentA[i] = now;
                    }
                }
            }
        }
        return answer;
    }

}

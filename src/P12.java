import java.util.Arrays;

public class P12 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {4, 2, 1}, 2));
        System.out.println(solution(new int[] {8, 7, 6, 3, 4}, 4));
        System.out.println(solution(new int[] {13, 7, 2}, 5));
        System.out.println(solution(new int[] {1, 2, 3, 4, 5, 6, 7}, 1));
    }
    public static int solution(int[] times, int n) {
        int[] g = new int[n];
        Arrays.fill(g, -1);

        int cnt = 0;
        int now = 0;
        int customer = 0;
        while (customer < times.length) {
            if (g[now] == -1) {
                g[now] = customer++;
            } else {
                int nCustomer = g[now];
                times[nCustomer] -= n;
                if (times[nCustomer] <= 0) {
                    g[now] = customer++;
                }
            }

            now++;
            now %= n;
            cnt++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (g[i] != -1) {
                max = max >= times[g[i]] ? max : times[g[i]];
            }
        }
        return cnt + max;
    }
}

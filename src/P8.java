import java.util.PriorityQueue;

public class P8 {
    public static void main(String[] args) {
        System.out.println(solution(10, 10, new int[]{100}, new int[]{100}, new int[]{7}, new int[]{10}));
        System.out.println(solution(90, 500, new int[]{70, 70, 0}, new int[]{0, 0, 500}, new int[]{100, 100, 2}, new int[]{4, 8, 1}));
    }

    static boolean check(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int length = g.length;
        long total = 0L;
        long tGold = 0L;
        long tSilver = 0L;

        for (int i = 0; i < length; i++) {
            long cnt = time / (2 * t[i]);
            if (time % (2 * t[i]) >= t[i])          //가능한 만큼 모두 왕복을 햇는데 편도로 갈 수 있을만큼 시간이 남았을 경우 -> 편도로 한번 주고 갈 수 있음
                cnt++;

            long mLoad = w[i] * cnt;
            tGold += Math.min(mLoad, g[i]);
            tSilver += Math.min(mLoad, s[i]);
            total += Math.min(g[i] + s[i], mLoad);
        }

        if (total >= a + b && tGold >= a && tSilver >= b) return true;
        return false;
    }
    static public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long str = 0;
        long end = (long) (1e9 * 2 * 1e5 * 2) ;
        long answer = end;
        while (str <= end) {
            long mid = (str + end) / 2;
            if (check(mid, a, b, g, s, w, t)){
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
            else
                str = mid + 1;
        }

        return answer;
    }

}

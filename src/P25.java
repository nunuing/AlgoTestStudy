import java.util.Arrays;
import java.util.Collections;

public class P25 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }
    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = times[times.length - 1] * (long)n;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
            }
            if (sum < n) {
                left = mid + 1;
            }
            else{
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}

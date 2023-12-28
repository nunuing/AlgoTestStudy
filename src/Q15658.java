import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15658 {
    static int n, maxSum, minSum;
    static int[] nums, result, cals;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        cals = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cals.length; i++) {
            cals[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[n];
        maxSum = Integer.MIN_VALUE;
        minSum = Integer.MAX_VALUE;
        choose(1);
        System.out.println(maxSum + "\n" + minSum);
    }

    static void choose(int level) {
        if (level == n) {
            int sum = nums[0];
            for (int i = 1; i < n; i++) {
                if (result[i] == 0) {
                    sum += nums[i];
                } else if (result[i] == 1) {
                    sum -= nums[i];
                } else if (result[i] == 2) {
                    sum *= nums[i];
                } else {
                    if (nums[i] < 0) {
                        int temp = Math.abs(nums[i]);
                        sum = (sum / temp) * -1;
                    }
                    else {
                        sum /= nums[i];
                    }
                }
            }
            maxSum = maxSum >= sum ? maxSum : sum;
            minSum = minSum <= sum ? minSum : sum;
            return;
        }

        for (int i = 0; i < cals.length; i++) {
            if (cals[i] > 0) {
                result[level] = i;
                cals[i]--;
                choose(level + 1);
                cals[i]++;
            }
        }
    }
}

import java.util.Arrays;

public class P1 {
    static int answer;
    static boolean[] isPrime;
    static int[] r;
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4}));
        System.out.println(solution(new int[]{1,2,7,6,4}));
    }
    static public int solution(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        isPrime = new boolean[sum + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < sum / 2; i++){
            for (int j = 2; i * j < isPrime.length; j++) {
                isPrime[i * j] = false;
            }
        }

        answer = 0;
        r = new int[3];
        dfs(0, 0, nums, r);
        return answer;
    }
    static public void dfs(int level, int now, int[] nums, int[] result){
        if (level == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += result[i];
            }
            if (isPrime[sum])
                answer++;
            return;
        }

        for (int i = now; i < nums.length; i++) {
            result[level] = nums[i];
            dfs(level + 1, i + 1, nums, result);
        }
    }
}

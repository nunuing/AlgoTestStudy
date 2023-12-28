import java.util.HashMap;

public class P14 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }
    public static int solution(int[] nums) {
        int answer = nums.length / 2;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.replace(nums[i], hm.get(nums[i]) + 1);
            }
            else {
                hm.put(nums[i], 1);
            }
        }

        int kNum = hm.size();
        return Math.min(answer, kNum);
    }
}

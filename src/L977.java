import java.util.Arrays;
import java.util.Map;

public class L977 {
    public static void main(String[] args) {
        int[] answer = sortedSquares(new int[]{-7,-3,2,3,11});

        for (int a : answer)
            System.out.println(a);
    }

    public static int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];

        int str = 0;
        int end = nums.length - 1;
        int idx = answer.length - 1;
        while (str <= end){
            if(Math.abs(nums[str]) >= Math.abs(nums[end])){
                answer[idx] = nums[str] * nums[str];
                str++;
            }
            else {
                answer[idx] = nums[end] * nums[end];
                end--;
            }
            idx--;
        }

        return  answer;
    }

//    public static int[] sortedSquares(int[] nums) {
//
//        for(int i = 0; i < nums.length; i++){
//            nums[i] = nums[i] * nums[i];
//        }
//
//        Arrays.sort(nums);
//        return nums;
//    }
}

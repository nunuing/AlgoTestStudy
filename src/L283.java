import java.util.Arrays;

public class L283 {
    public static void main(String[] args) {

    }
    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[idx] = nums[i];
                idx++;
            }
        }
        Arrays.fill(nums, idx, nums.length - 1, 0);
    }
}

public class L724 {
    public static void main(String[] args) {

    }
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++)
            total += nums[i];

        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > 0)
                left += nums[i -1];

            int right = total - left - nums[i];
            if(left == right)
                return i;
        }

        return -1;
    }
}

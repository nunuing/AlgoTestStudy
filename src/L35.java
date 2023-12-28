public class L35 {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int str = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (str <= end){
            mid = str + (end - str) / 2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                str = mid + 1;
            }
        }
        if(target > nums[mid])
            return mid + 1;
        return mid;
    }
}

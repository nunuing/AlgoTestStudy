public class L704 {
    public static void main(String[] args) {
        int[] input = {-1, 0, 3, 5, 9, 12};

        System.out.println(search(input, 9));
    }

    public static int search(int[] nums, int target) {
        int str = 0;
        int end = nums.length - 1;

        while (str < end) {
            int mid = (str + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                str = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
        }

        return -1;
    }
}

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class L189 {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 2);
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length - 1;
        k = k % nums.length;
        reverse(nums, 0, len - k);
        reverse(nums, len - k + 1, len);
        reverse(nums, 0, len);



        for (int a : nums)
            System.out.println(a);
    }

    public static void reverse(int[] nums, int str, int end) {
        while (str < end) {
            int temp = nums[str];
            nums[str] = nums[end];
            nums[end] = temp;

            str++;
            end--;
        }
    }

//    public static void rotate(int[] nums, int k) {
//        int len = nums.length;
//        int[] temp = Arrays.copyOf(nums, len);
//
//        int before;
//        int after = k;
//        for(before = 0; before < len; before++){
//           nums[after % len] = temp[before];
//           after++;
//        }

//    }
}

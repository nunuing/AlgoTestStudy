public class L167 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] numbers, int target) {

        int str = 0;
        int end = numbers.length - 1;
        while (str < end){
            int sum = numbers[str] + numbers[end];
            if(sum == target)
                return new int[]{str + 1, end + 1};
            else if(sum < target)
                str++;
            else if(sum > target)
                end--;
        }

        return null;
    }
}

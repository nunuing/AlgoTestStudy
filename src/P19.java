public class P19 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14}));
        System.out.println(solution(new int[]{1,2,3}));
    }
    public static int solution(int[] arr) {
        int answer = 0;
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxVal = maxVal > arr[i] ? maxVal : arr[i];
        }

        answer = maxVal;
        while (true) {
            boolean check = true;
            for (int i = 0; i < arr.length; i++) {
                if (answer % arr[i] != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                break;
            }
            answer += maxVal;
        }
        return answer;
    }
}

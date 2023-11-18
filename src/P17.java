public class P17 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,3,2,1}));
        System.out.println(solution(new int[]{10}));
    }
    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] answer = new int[arr.length - 1];
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == minIndex) {
                continue;
            }
            answer[index++] = arr[i];
        }

        return answer;
    }
}

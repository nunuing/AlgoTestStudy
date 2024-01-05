import java.util.Arrays;

public class P15 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            int tl = commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[tl];
            for (int j = 0;  j < tl; j++) {
                temp[j] = array[commands[i][0] + j - 1];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}

import java.util.Arrays;

public class P16 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));

    }
    public static String solution(int[] numbers) {
        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (temp[0].equals("0"))
            return "0";

        StringBuilder answer = new StringBuilder();
        for (String str : temp) {
            answer.append(str);
        }
        return answer.toString();
    }
}

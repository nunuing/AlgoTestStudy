import java.util.Arrays;

public class P33 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }
    static public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int idx = 0;
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                answer++;
                idx++;
            }
            else {
                answer++;
            }
        }
        return answer;
    }
}

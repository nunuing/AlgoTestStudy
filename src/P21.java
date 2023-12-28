public class P21 {
    static int tNum, limit, answer;
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }
    public static int solution(int[] numbers, int target) {
        answer = 0;
        int[] result = new int[numbers.length];
        limit = numbers.length;
        tNum = target;
        dfs(numbers, result, 0);
        return answer;
    }
    public static void dfs (int[] numbers, int[] result, int depth){
        if (depth == limit) {
            int sum = 0;
            for (int i = 0; i < depth; i++) {
                if (result[i] == 0) {
                    sum += numbers[i];
                }
                else {
                    sum += (-1 * numbers[i]);
                }
            }
            if (sum == tNum) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            result[depth] = i;
            dfs(numbers, result, depth + 1);
        }
    }
}

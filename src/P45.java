public class P45 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
    static public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(stones, k, mid)) {
                answer = Math.max(mid, answer);
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return answer;
    }
    static boolean check(int[] stones, int k, int num) {
        int skip = 0;
        for (int stone : stones) {
            if (stone - num < 0) {
                skip++;
            }
            else {
                skip = 0;
            }
            if (skip == k)
                return false;
        }
        return true;
    }
}

public class P46 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 1}));
    }
    static public int solution(int[] money) {
        int answer = 0;
        int length = money.length;
        int[] dp1 = new int[length];        //첫번째 훔치는 경우 -> 마지막과 두번째 집은 훔칠 수 없음
        int[] dp2 = new int[length];        //첫번째 안 훔치는 경우

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);

        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            answer = Math.max(dp2[i], answer);

            if (i == length - 1)
                break;
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
            answer = Math.max(dp1[i], answer);
        }

        return answer;
    }
}

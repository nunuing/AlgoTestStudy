public class P9 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {100,180,360,100,270}));
    }
    static public long solution(int[] weights) {
        long answer = 0;
        int[] wNum = new int[100001];
        for (int i = 0; i < weights.length; i++)
            wNum[weights[i]]++;

        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            if (wNum[w] >= 2) {
                answer += (wNum[w] - 1);
            }

            for (int j = 2; j <= 4; j++) {
                int tWeight = w * j;
                for (int k = 2; k <= 4; k++) {
                    if (j == k)
                        continue;

                    if (tWeight % k == 0 && wNum[tWeight/k] >= 1) {
                        answer += wNum[tWeight/k];
                    }
                }
            }
        }
        return answer / 2;
    }
}

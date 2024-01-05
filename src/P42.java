import java.util.Arrays;

public class P42 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }
    static public int solution(int[][] scores) {
        int[] wonho = scores[0];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o2[0]-o1[0];
        });

        int mScore = scores[0][1];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < mScore) {
                if (scores[i][0] == wonho[0] && scores[i][1] == wonho[1]) {
                    return -1;
                }
                scores[i][0] = -1;
                scores[i][1] = -1;
            }
            else {
                mScore = scores[i][1];
            }
        }
        Arrays.sort(scores, (o1, o2) -> {
            return (o2[0] + o2[1]) - (o1[0] + o1[1]);
        });

        int answer = 1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] + scores[i][1] > wonho[0] + wonho[1])
                answer++;
            else
                break;
        }
        return answer;
    }
}

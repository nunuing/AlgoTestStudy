import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class P36 {
    static char[] cards;
    static int answer;
    static boolean[] isPrime;
    static boolean[] used;
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
    static public int solution(String numbers) {
        cards = numbers.toCharArray();
        isPrime = new boolean[(int) Math.pow(10, numbers.length())];
        int l = isPrime.length;
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i <= l / 2; i++) {
            for (int j = 2; j * i < l; j++) {
                isPrime[j*i] = true;
            }
        }

        answer = 0;
        used = new boolean[cards.length];
        dfs(0, cards.length, "");
        return answer;
    }
    static void dfs(int depth, int k, String result) {
        if (result.length() > 0) {
            int temp = Integer.parseInt(result);
            if (!isPrime[temp]) {
                isPrime[temp] = true;
                answer++;
            }
        }
        if (depth >= k) {
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(depth + 1, k, result + cards[i]);
                used[i] = false;
            }
        }
    }
}

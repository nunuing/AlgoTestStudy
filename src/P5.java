import java.util.HashMap;


public class P5 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        System.out.println(solution(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
        System.out.println(solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"} ));
    }
    static public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int num = 2, turn = 1;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        map.put(words[0], true);
        for (int i = 1; i < words.length; i++) {
            char c1 = words[i - 1].charAt(words[i - 1].length() - 1);
            char c2 = words[i].charAt(0);
            if (c1 != c2 || words[1].length() == 1 || map.containsKey(words[i])) {
                answer = new int[]{num, turn};
                break;
            }
            map.put(words[i], true);
            if (++num > n) {
                turn++;
                num = 1;
            }
        }
        return answer;
    }
}

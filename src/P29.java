import java.util.ArrayList;
import java.util.Collections;

public class P29 {
    static String[] chars = {"A", "E", "I", "O", "U"};
    static ArrayList<String> words = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    static public int solution(String word) {
        int answer = 0;
        dfs(0, "");

        Collections.sort(words);
        for (answer = 0; answer < words.size(); answer++) {
            if (words.get(answer).equals(word)) {
                answer++;
                break;
            }
        }
        return answer;
    }
    static void dfs(int depth, String word) {
        if (depth > 5)
            return;
        if (word.length() != 0 && !words.contains(word))
            words.add(word);
        for (int i = 0; i < chars.length; i++) {
            dfs(depth + 1, word + chars[i]);
        }
    }
}

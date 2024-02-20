import java.util.Stack;

public class P18 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }
    public static int solution(String s) {
        String[] matching = {"zero",  "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp < '0' || temp > '9') {
                for (int j = 0; j < matching.length; j++) {
                    int tl = matching[j].length();
                    if (i + tl > s.length()) continue;
                    String str = s.substring(i, i + tl);
                    if (str.compareTo(matching[j]) == 0) {
                        stack.push(j);
                        i += tl - 1;
                        break;
                    }
                }
            }
            else {
                stack.push(temp - '0');
            }
        }

        int answer = 0;
        int now = 1;
        while (!stack.empty()) {
            answer += now * stack.pop();
            now *= 10;
        }
        return answer;
    }
}

import java.util.Stack;

public class P52 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (check(s.substring(s.length() - i - 1) + s.substring(0, s.length() - i - 1))) {
                answer++;
            }
        }
        return answer;
    }
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                }
                else if (stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                }
                else if (stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

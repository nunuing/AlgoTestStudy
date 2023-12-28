import java.util.Stack;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
    static boolean solution(String s) {
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(')
                stack.push(input[i]);
            else {
                if (!stack.empty())
                    stack.pop();
                else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

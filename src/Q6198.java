import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= h[i]) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(h[i]);
        }
        System.out.println(answer);
    }
}

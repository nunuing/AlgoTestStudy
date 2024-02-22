import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek() > ty) {
                stack.pop();
                answer++;
            }
            if (!stack.isEmpty() && stack.peek() == ty)
                continue;
            stack.push(ty);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() > 0)
                answer++;
            stack.pop();
        }
        System.out.println(answer);
    }

}
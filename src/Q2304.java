import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] height = new int[1001];
        int str = 1002;
        int fin = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            height[x] = l;
            str = Math.min(str, x);
            fin = Math.max(fin, x);
        }


        Stack<Integer> stack = new Stack<>();
        int temp = height[str];

        for (int i = str + 1; i <= fin; i++) {
            if(height[i] < temp) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()) {
                    int pos = stack.pop();
                    height[pos] = temp;
                }
                temp = height[i];
            }
        }
        stack.clear();

        temp = height[fin];
        for (int i = fin - 1; i >= str; i--) {
            if (height[i] < temp) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()) {
                    int pos = stack.pop();
                    height[pos] = temp;
                }
                temp = height[i];
            }
        }

        int answer = 0;
        for (int i = str; i <= fin; i++) {
            answer += height[i];
        }
        System.out.println(answer);
    }
}

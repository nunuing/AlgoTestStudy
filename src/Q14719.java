import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] rain = new int[w];
        int temp = height[0];
        for (int i = 1; i < w; i++) {
            if (height[i] < temp) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    rain[x] = temp - height[x];
                }
                temp = height[i];
            }
        }
        stack.clear();
        temp = height[w - 1];
        for (int i = w - 2; i >= 0; i--) {
            if (height[i] < temp) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()){
                    int x = stack.pop();
                    rain[x] = temp - height[x];
                }
                temp = height[i];
            }
        }
        int answer = 0;
        for (int i = 0; i < w; i++) {
            answer += rain[i];
        }
        System.out.println(answer);
    }
}

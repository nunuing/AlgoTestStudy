import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2304_2 {      //stack
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];
        int[] height = new int[1002];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            height[map[i][0]] = map[i][1];
        }

        Arrays.sort(map, (o1, o2) -> o1[0] - o2[0]);

        Stack<Integer> stack = new Stack<>();
        int temp = map[0][1];
        for (int i = map[0][0] + 1; i <= map[n - 1][0]; i++) {
            if (height[i] < temp) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    height[x] = temp;
                }
                temp = height[i];
            }
        }
        stack.clear();

        temp = map[n - 1][1];
        for (int i = map[n - 1][0] - 1; i >= map[0][0]; i--) {
            if (height[i] < temp) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    height[x] = temp;
                }
                temp = height[i];
            }
        }
        int answer = 0;
        for (int i = map[0][0]; i <= map[n - 1][0]; i++) {
            answer += height[i];
        }

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int method1 = Integer.parseInt(st.nextToken());
        int method2 = Integer.parseInt(st.nextToken());

        int num = Integer.parseInt(br.readLine());
        int[] input = new int[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= num; i++){
            input[num - i] = Integer.parseInt(st.nextToken());
        }

        int before = 0;
        for(int i = 0; i < num; i++){
            before += (Math.pow(method1, i) * input[i]);
        }

        Stack<Integer> answer = new Stack<>();
        while (before > 0){
            answer.push(before % method2);

            before /= method2;
        }

        while (!answer.isEmpty()){
            System.out.print(answer.pop()+ " ");
        }
        System.out.println();

    }
}

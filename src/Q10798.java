import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] answer = new StringBuilder[16];
        for (int i = 0; i < answer.length; i++)
            answer[i] = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                answer[j].append(input[j]);
            }
        }

        for (int i = 0; i < answer.length; i++) {
                System.out.print(answer[i]);

        }
    }
}

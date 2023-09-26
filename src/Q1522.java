import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int cntA = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'a')
                cntA++;
        }

        int answer = cntA + 1;
        int l = input.length;
        for (int i = 0; i < l; i++) {
            int temp = 0;
            for (int j = 0; j < cntA; j++) {
                if (input[(i + j) % l] == 'b')
                    temp++;
            }
            answer = Math.min(answer, temp);
        }
        System.out.println(answer);
    }
}

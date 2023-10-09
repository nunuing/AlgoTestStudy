import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        String[] answers = {"Equilateral", "Isosceles", "Scalene", "Invalid"};
        while (true) {
            st = new StringTokenizer(br.readLine());

            int[] inputs = new int[3];
            for (int i = 0; i < 3; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }
            if (inputs[0] == 0 && inputs[1] == 0 && inputs[2] == 0)
                break;
            
            Arrays.sort(inputs);

            if (inputs[0] + inputs[1] <= inputs[2])
                bw.write(answers[3] + "\n");
            else if ((inputs[0] == inputs[1]) &&(inputs[1] == inputs[2]) && (inputs[2] == inputs[0]))
                bw.write(answers[0] + "\n");
            else if ((inputs[0] != inputs[1]) &&(inputs[1] != inputs[2]) && (inputs[2] != inputs[0]))
                bw.write(answers[2] + "\n");
            else
                bw.write(answers[1] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}

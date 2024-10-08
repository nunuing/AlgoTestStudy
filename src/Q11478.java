import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        HashSet<String> answer = new HashSet<>();

        int str = 0;
        int end = 0;
        while (str <= end & end < input.length()) {
            answer.add(input.substring(str, end + 1));
            end++;
            if (end >= input.length()) {
                end = ++str;
            }
        }
        System.out.println(answer.size());
    }
}

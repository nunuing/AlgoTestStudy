import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        int answer = 0;
        String now = "";
        while (!now.equals(p)) {
            for (int i = p.length(); i >= now.length(); i--) {
                String temp = p.substring(now.length(), i);
                if (s.contains(temp)) {
                    now += temp;
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

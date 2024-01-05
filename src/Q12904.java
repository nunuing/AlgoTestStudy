import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while (s.length() < t.length()) {
            int tl = t.length() - 1;
            if (t.charAt(tl) == 'A') {
                t.deleteCharAt(tl);
            }
            else {
                t.deleteCharAt(tl);
                t.reverse();
            }
        }

        if (s.toString().equals(t.toString()))
            System.out.println(1);
        else
            System.out.println(0);
    }
}

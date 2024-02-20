import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12919 {
    static String target, input;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        target = br.readLine();

        check = false;
        dfs(target);
        if (check)
            System.out.println(1);
        else
            System.out.println(0);
    }
    static void dfs(String now) {
        if (now.length() == input.length()) {
            if (now.equals(input)){
                check = true;
            }
            return;
        }
        if (now.charAt(0) == 'B') {
            StringBuilder temp = new StringBuilder(now);
            temp.deleteCharAt(0);
            dfs(temp.reverse().toString());
        }
        if (now.charAt(now.length() - 1) == 'A') {
            dfs(now.substring(0, now.length() - 1));
        }
    }
}

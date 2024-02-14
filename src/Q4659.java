import java.io.*;

public class Q4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String temp = br.readLine();
            if (temp.compareTo("end") == 0) {
                System.out.print(sb);
                break;
            }

            if (check(temp.toCharArray())) {
                sb.append("<" + temp + "> is acceptable.\n");
            }
            else {
                sb.append("<" + temp + "> not acceptable.\n");
            }
        }
        br.close();
    }
    static boolean check(char[] input) {
        int cnt = 0;
        int v_cnt = 0;
        int c_cnt = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
                cnt++;
                c_cnt = 0;
                v_cnt++;
                if (v_cnt == 3)
                    return false;
            }
            else {
                v_cnt = 0;
                c_cnt++;
                if (c_cnt == 3)
                    return false;
            }
            if (i != 0) {
                if (input[i] == input[i - 1] &&input[i] != 'e' && input[i] != 'o')
                    return false;
            }
        }
        if (cnt == 0)
            return false;

        return true;
    }
}

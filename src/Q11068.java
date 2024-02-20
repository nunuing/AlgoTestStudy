import java.io.*;
import java.util.ArrayList;

public class Q11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int num = Integer.parseInt(br.readLine());

            boolean judge = false;
            for (int i = 2; i <= 64; i++) {
                ArrayList<Integer> converted = new ArrayList<>();
                int temp = num;
                while (temp > 0) {
                    converted.add(temp%i);
                    temp /= i;
                }
                boolean check = true;
                int length = converted.size();
                for (int j = 0; j < length / 2; j++) {
                    if (converted.get(j) != converted.get(length - j - 1)) {
                        check = false;
                        break;
                    }
                }
                if (check){
                    judge = true;
                    break;
                }
            }
            if (judge)
                bw.append("1\n");
            else
                bw.append("0\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

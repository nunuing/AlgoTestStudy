import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q14232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        ArrayList<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (long i = 2; i <= Math.sqrt(k); i++) {
            while (k % i == 0) {
                list.add(i);
                k /= i;
            }
        }
        if (k != 1)
            list.add(k);
        Collections.sort(list);
        sb.append(list.size() + "\n");
        for (long a : list)
            sb.append(a + " ");
        System.out.println(sb);
    }
}

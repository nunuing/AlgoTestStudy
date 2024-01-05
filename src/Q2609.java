import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int str = (n < m) ? m : n;

        for(; str >= 1; str--){
            if((n % str == 0) && (m % str == 0))
                break;
        }
        System.out.println(str);

        str = (n < m) ? m : n;
        while (true){
            if((str % n == 0) && (str % m == 0))
                break;
            str++;
        }
        System.out.println(str);
    }
}

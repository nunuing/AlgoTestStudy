import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int team = 0;
        while (n + m - k >= 3) {
            if (n - 2 >= 0 && m - 1 >= 0) {
                n-=2;
                m--;
                team++;
            }
            else break;
        }
        System.out.println(team);
    }
}

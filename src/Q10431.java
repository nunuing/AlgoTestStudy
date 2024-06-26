import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10431 {
    static int[] kids;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        while (++cur <= p) {
            kids = new int[20];
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int i = 0; i < kids.length; i++) {
                kids[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < kids.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (kids[j] > kids[i])
                        answer++;
                }
            }
            sb.append(cur + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}

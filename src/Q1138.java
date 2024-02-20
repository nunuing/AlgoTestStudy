import javax.management.MBeanRegistration;
import java.io.*;
import java.util.StringTokenizer;

public class Q1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] people = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = people[i] + 1;
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (result[j] == 0) {
                    cnt++;
                }
                if (num == cnt){
                    result[j] = i;
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}

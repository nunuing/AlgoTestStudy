import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean[] volunteers = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int temp = Integer.parseInt(st.nextToken());
            volunteers[temp] = true;
        }

        if (r == n) {
            System.out.println("*");
        }
        else {
            for (int i = 1; i <= n; i++) {
                if(!volunteers[i])
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

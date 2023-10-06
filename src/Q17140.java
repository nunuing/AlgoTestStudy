import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17140 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] a = new int[3][3];
        for (int i = 0; i < a.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time++ <= 100) {
            if (a[r][c] == k)
                break;

        }
        if (time > 100) {
            System.out.println(-1);
        }
        else {
            System.out.println(time);
        }
    }
}

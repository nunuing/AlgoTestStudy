import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] sisters = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sisters[i] = Math.abs(temp - s);
        }


        int gcd = sisters[0];
        for(int i = 1; i < n; i++){
            gcd = getGCD(gcd, sisters[i]);
        }

        System.out.println(gcd);

    }
    public static int getGCD(int n, int m){
        int a = Math.max(n, m);
        int b = Math.min(n, m);

        while (a % b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}
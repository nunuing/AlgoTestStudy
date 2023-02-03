import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int earth = 1;
        int sun = 1;
        int moon = 1;

        int year = 1;
        while (true){
            if(earth == e && sun == s && moon == m){
                System.out.println(year);
                return;
            }

            earth++;
            sun++;
            moon++;
            year++;

            if(earth == 16)
                earth = 1;
            if (sun == 29)
                sun = 1;
            if(moon == 20)
                moon = 1;
        }
    }
}

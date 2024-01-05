import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        while (num-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int str = (n < m) ? m : n;

            for(; str >= 1; str--){
                if((n % str == 0) && (m % str == 0))
                    break;
            }

            int min = (n*m)/str; //최소 공배수
            System.out.println(min);
        }
    }
}

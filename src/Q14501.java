import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {
    static int n;
    static int[] t;
    static int[] p;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];
        
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        scheduling(1, 0);

        System.out.println(answer);
    }
    static void scheduling(int day, int price){
        if(day > n){
            if(answer < price) answer = price;
            return;
        }
        if(day + t[day] - 1 <= n){
            scheduling(day + t[day], price + p[day]);
        }
        scheduling(day + 1, price);
    }
}

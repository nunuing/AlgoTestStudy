import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] data = new int[m];
        picking(n, m, data, 1, 0);
    }
    static void picking(int n, int m, int[] data, int str, int cnt){
        if(cnt == m){
            for(int i = 0; i < m; i++)
                System.out.print(data[i] + " ");
            System.out.println();
            return;
        }
        for(int i = str; i <= n; i++){
            data[cnt] = i;
            picking(n, m, data, i, cnt + 1);
        }
    }
}

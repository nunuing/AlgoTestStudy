import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15651 {
    static int n, m;
    static int[] data;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        data = new int[m];
        
        picking(0);
        
        bw.flush();
        bw.close();
    }
    static void picking(int cnt) throws IOException{
        if(cnt == m){
            for(int i = 0; i < m; i++){
                bw.append(data[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            data[cnt] = i;
            picking(cnt + 1);
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {
    static BufferedWriter bw;
    static int n, m;
    static int[] data, result;
    static Boolean[] isPicked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        data = new int[n];
        isPicked = new Boolean[n];
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
            isPicked[i] = false;
        }
        Arrays.sort(data);

        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        result = new int[m];

        picking(0);
        
        bw.flush();
        bw.close();
    }
    static void picking(int cnt) throws IOException{
        if(cnt == m){
            for(int i = 0; i < m; i++){
                bw.append(result[i] + " ");
            }
            bw.write('\n');
            return;
        }
        for(int i = 0; i < n; i++){
            if (!isPicked[i]) {
                isPicked[i] = true;
                result[cnt] = data[i];
                picking(cnt + 1);
                isPicked[i] = false;
            }
        }
    }
}

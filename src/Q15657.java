import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15657 {
    static int n, m;
    static int[] data, result;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        data = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        result = new int[m];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        picking(0, 0);

        bw.close();
    }
    static void picking(int cnt, int str) throws IOException{
        if(cnt == m){
            for(int i = 0; i < m; i++){
                bw.append(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i = str; i < n; i++){
            result[cnt] = data[i];
            picking(cnt + 1, i);
        }
    }
}

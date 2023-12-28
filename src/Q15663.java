import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15663 {
    static int n, m; 
    static int[] data, result;
    static boolean[] isPicked;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        data = new int[n];
        isPicked = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
            isPicked[i] = false;
        }

        Arrays.sort(data);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new int[m];
        picking(0);

        bw.close();

    }
    static void picking(int cnt) throws IOException{
        if(cnt == m){
            for(int i = 0; i < m; i++){
                bw.append(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        int check = -1;
        for(int i = 0; i < n; i++){
            if(!isPicked[i] && check != data[i]){
                isPicked[i] = true;
                result[cnt] = data[i];
                check = data[i];
                picking(cnt + 1);
                isPicked[i] = false; 
            }
        }
    }
}

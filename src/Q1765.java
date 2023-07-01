import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1765 {
    static String[] data, result;
    static boolean[] isPicked;
    static int l, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        data = input.split(" ");

        Arrays.sort(data);
        
        result = new String[l];
        isPicked = new boolean[c];
        for(int i = 0; i < c; i++)
            isPicked[i] = false;
        
        picking(0, 0);

    }
    static void picking(int cnt, int now){
        if(cnt == l){
            for(int i = 0; i < l; i++){
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }
        for(int i = now; i < c; i++){
            if(!isPicked[i]){
                isPicked[i] = true;
                result[cnt] = data[i];
                picking(cnt + 1, now + 1);
                isPicked[i] = false;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10819 {
    static int n, answer;
    static int[] data, result;
    static boolean[] isPicked;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new int[n];
        isPicked = new boolean[n];
        for(int i = 0;  i < n; i ++){
            data[i] = Integer.parseInt(st.nextToken());
            isPicked[i] = false;
        }

        result = new int[n];
        answer = -800;
        
        picking(0);
        System.out.println(answer);
    }
    static void picking(int cnt){
        if(cnt == n){
            int temp = 0;
            for(int i = 1; i < n; i++){
                temp += Math.abs(result[i - 1] - result[i]);
            }
            answer = temp > answer ? temp : answer;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!isPicked[i]){
                result[cnt] = data[i];
                isPicked[i] = true;
                picking(cnt + 1);
                isPicked[i] = false;
            }
        }
    }
}

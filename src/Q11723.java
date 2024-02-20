import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11723 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] numbers = new boolean[21];
        Arrays.fill(numbers, false);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("add")){
                int temp = Integer.parseInt(st.nextToken());
                if(!numbers[temp]){
                    numbers[temp] = true;
                }
            }
            else if(order.equals("remove")){
                int temp = Integer.parseInt(st.nextToken());
                if(numbers[temp]){
                    numbers[temp] = false;
                }
            }
            else if(order.equals("check")){
                int temp = Integer.parseInt(st.nextToken());
                if(numbers[temp]){
                    bw.append(1 + "\n");
                }
                else{
                    bw.append(0 + "\n");
                }
            }
            else if(order.equals("toggle")){
                int temp = Integer.parseInt(st.nextToken());
                numbers[temp] = !numbers[temp];
            }
            else if(order.equals("all")){
                Arrays.fill(numbers, true);
            }
            else if(order.equals("empty")){
                Arrays.fill(numbers, false);
            }        
        }
        br.close();
        
        bw.flush();
        bw.close();
    }

}

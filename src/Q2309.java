import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = new int[9];

        int sum = 0;
        for(int i = 0; i < 9; i++){
            inputs[i] = Integer.parseInt(br.readLine());
            sum += inputs[i];
        }

        Arrays.sort(inputs);
        boolean ok = false;
        for(int i = 0; i < 9; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum - inputs[i] - inputs[j] == 100){
                    for(int k = 0; k < 9; k++){
                        if(k != i && k != j)
                            System.out.println(inputs[k]);
                    }
                    ok = true;
                    break;
                }
            }
            if(ok)
                break;
        }

    }
}

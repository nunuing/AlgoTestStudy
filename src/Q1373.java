import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        if(str.length() % 3 == 1){
            str = "00" + str;
        }
        else if(str.length() % 3 == 2){
            str = "0" + str;
        }

        char[] inputs = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inputs.length; i+=3){
            int num = 0;
            if(inputs[i] == '1')
                num += 4;

            if(inputs[i + 1] == '1')
                num += 2;

            if(inputs[i + 2] == '1')
                num += 1;

            sb.append(num);
        }
        System.out.println(sb);
    }
}

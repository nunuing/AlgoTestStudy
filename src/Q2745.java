import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        char[] chars = st.nextToken().toCharArray();
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        int multiple = 0;
        for(int i = chars.length - 1; i >= 0; i--){
            int num = 0;
            if(chars[i] >= '0' && chars[i] <= '9')
                num = chars[i] - '0';
            else
                num = chars[i] - 'A' + 10;

            answer += (Math.pow(b, multiple) * num);
            multiple++;
        }

        System.out.println(answer);
    }
}

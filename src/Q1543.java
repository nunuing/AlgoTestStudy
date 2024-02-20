import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] document = br.readLine().toCharArray();
        char[] world = br.readLine().toCharArray();

        br.close();

        int answer = 0;
        int wlen = world.length;
        for (int i = 0; i + wlen <= document.length; i++){
            boolean jud = true;
            for (int j = 0; j < wlen; j++) {
                if (document[i + j] != world[j]) {
                    jud = false;
                    break;
                }
            }
            if (jud) {
                answer++;
                i += (wlen - 1);
            }
        }
        System.out.println(answer);
    }
}

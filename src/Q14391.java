import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] paper = new int[n][m];
        for(int i = 0; i < n; i++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                paper[i][j] = Character.getNumericValue(temp[j]);
            }
        }

        
    }
}

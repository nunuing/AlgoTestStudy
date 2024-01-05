import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] teams = new int[2 * n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            teams[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(teams);

        int length = teams.length - 1;
        int answer = teams[length] * 2;
        for (int i = 0; i < n; i++) {
            int temp = teams[i] + teams[length - i];
            answer = Math.min(answer, temp);
        }

        System.out.println(answer);
    }
}
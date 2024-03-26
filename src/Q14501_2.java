import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501_2 {
    static int answer = 0, n;
    static int[][] consulting;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        consulting = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);
        System.out.println(answer);
    }
    static public void recur(int day, int prices) {
        if (day <= n)
            answer = Math.max(answer, prices);

        if (day >= n)
            return;
        //해당 날짜에 상담을 하는 경우
        recur(day + consulting[day][0] , prices + consulting[day][1]);
        recur(day + 1, prices);
    }
}

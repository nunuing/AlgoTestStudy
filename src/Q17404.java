import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17404 {
    public static final int MAX = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] inputs = new int[n + 1][3];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //첫번째 집이 Red(0)색일 경우
        int[][] dp1 = new int[n + 1][3];
        dp1[1][0] = inputs[1][0];               //red만 선택되어야함
        dp1[1][1] = MAX;
        dp1[1][2] = MAX;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    dp1[i][j] = Math.min(dp1[i -1][1], dp1[i -1][2]) + inputs[i][j];
                else if(j == 1)
                    dp1[i][j] = Math.min(dp1[i -1][0], dp1[i -1][2]) + inputs[i][j];
                else if(j == 2)
                    dp1[i][j] = Math.min(dp1[i -1][0], dp1[i -1][1]) + inputs[i][j];
            }
        }

        int answer = Math.min(dp1[n][1], dp1[n][2]);

        //첫번째 집이 Green(1)색일 경우
        int[][] dp2 = new int[n + 1][3];
        dp2[1][0] = MAX;
        dp2[1][1] = inputs[1][1];       //Green만 선택되어야함
        dp2[1][2] = MAX;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    dp2[i][j] = Math.min(dp2[i -1][1], dp2[i -1][2]) + inputs[i][j];
                else if(j == 1)
                    dp2[i][j] = Math.min(dp2[i -1][0], dp2[i -1][2]) + inputs[i][j];
                else if(j == 2)
                    dp2[i][j] = Math.min(dp2[i -1][0], dp2[i -1][1]) + inputs[i][j];
            }
        }

        answer = Math.min(answer, Math.min(dp2[n][0],dp2[n][2]));

        //첫번째 집이 Blue(2)색일 경우
        int[][] dp3 = new int[n + 1][3];
        dp3[1][0] = MAX;
        dp3[1][1] = MAX;
        dp3[1][2] = inputs[1][2];           //Blue만 선택되어야함
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    dp3[i][j] = Math.min(dp3[i -1][1], dp3[i -1][2]) + inputs[i][j];
                else if(j == 1)
                    dp3[i][j] = Math.min(dp3[i -1][0], dp3[i -1][2]) + inputs[i][j];
                else if(j == 2)
                    dp3[i][j] = Math.min(dp3[i -1][0], dp3[i -1][1]) + inputs[i][j];
            }
        }

        answer = Math.min(answer, Math.min(dp3[n][0], dp3[n][1]));

        System.out.println(answer);
    }
}

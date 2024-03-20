import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q19942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mp = Integer.parseInt(st.nextToken());
        int mf = Integer.parseInt(st.nextToken());
        int ms = Integer.parseInt(st.nextToken());
        int mv = Integer.parseInt(st.nextToken());

        int[][] ingredients = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
            ingredients[i][2] = Integer.parseInt(st.nextToken());
            ingredients[i][3] = Integer.parseInt(st.nextToken());
            ingredients[i][4] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 1; i < (1 << n); i++) {
            int p = 0, f = 0, s = 0, v = 0, sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    p += ingredients[j][0];
                    f += ingredients[j][1];
                    s += ingredients[j][2];
                    v += ingredients[j][3];
                    sum += ingredients[j][4];
                }
            }
            if ((p >= mp) && (f >= mf) && (s >= ms) && (v >= mv)) {
                if (sum <= result) {
                    if (sum < result)
                        answer.clear();
                    result = sum;
                    String temp = "";
                    for (int k = 0; k < n; k++) {
                        if ((i & (1 << k)) > 0) {
                            temp += (k + 1) + " ";
                        }
                    }
                    answer.add(temp);
                }
            }
        }
        if (answer.isEmpty()) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
            Collections.sort(answer);
            for (String ans : answer) {
                System.out.println(ans);
            }
        }
    }
}

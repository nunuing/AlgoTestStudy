import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int j = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());

        int[] jersey = new int[j + 1];
        boolean[] selected = new boolean[j + 1];

        for (int i = 1; i <= j; i++) {
            jersey[i] = getSizeNum(br.readLine());
        }

        StringTokenizer st;
        int cnt = 0;
        for (int i = 1; i <= a; i++) {
            st = new StringTokenizer(br.readLine());
            int size = getSizeNum(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (!selected[num]) {
                if (jersey[num] >= size) {
                    selected[num] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static int getSizeNum(String size) {
        switch (size) {
            case "L" :
                return 3;
            case "M" :
                return 2;
            case "S" :
                return 1;
            default:
                return 0;
        }
    }
}

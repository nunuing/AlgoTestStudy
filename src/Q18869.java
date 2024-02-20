import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] universe = new int[m][n];
        List<Integer>[] lists = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < n; j++) {
                universe[i][j] = Integer.parseInt(st.nextToken());
                set.add(universe[i][j]);
            }
            lists[i] = new ArrayList<>(set);
            Collections.sort(lists[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                universe[i][j] = Collections.binarySearch(lists[i], universe[i][j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (Arrays.equals(universe[i], universe[j]))
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.clear();
            for (int j = i; j < i + k; j++) {
                int temp = j % n;
                int kind = sushi[temp];
                if (!map.containsKey(kind)) {
                    map.put(kind, 1);
                }
            }
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            cnt = Math.max(cnt, map.size());
        }
        System.out.println(cnt);
    }
}

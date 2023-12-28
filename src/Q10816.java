import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(cards[i])) {
                int temp = map.get(cards[i]);
                map.replace(cards[i], temp + 1);
            }
            else
                map.put(cards[i], 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (!map.containsKey(target)) {
                sb.append(0 + " ");
            }
            else {
                sb.append(map.get(target) + " ");
            }
        }

        System.out.println(sb);
    }
}

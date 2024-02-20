import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputs);
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!position.containsKey(inputs[i])) {
                position.put(inputs[i], i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(br.readLine());
            if (!position.containsKey(target))
                bw.append(-1 + "\n");
            else
                bw.append(position.get(target) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            if (!map.containsKey(inputs[i]))
                map.put(inputs[i], 0);
        }

        int[] sInputs = new int[map.size()];
        int idx = 0;
        for (int i : map.keySet()) {
            sInputs[idx++] = i;
        }
        Arrays.sort(sInputs);
        Map<Integer, Integer> answer = new HashMap<>();
        for (int i = 0; i < sInputs.length; i++) {
            answer.put(sInputs[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer.get(inputs[i]) + " ");
        }
        System.out.println(sb);
    }
}
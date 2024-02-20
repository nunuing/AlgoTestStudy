import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Boolean> keywords = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if (!keywords.containsKey(temp)) {
                keywords.put(temp, true);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            String[] write = br.readLine().split(",");
            for (int j = 0; j < write.length; j++) {
                if (keywords.containsKey(write[j])){
                    keywords.remove(write[j]);
                }
            }
            bw.append(keywords.size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

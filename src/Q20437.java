import java.io.*;

public class Q20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            char[] input = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            if (k == 1) {
                bw.append("1 1\n");
                continue;
            }

            int[] alphabet = new int['z' - 'a' + 1];
            for (int i = 0; i < input.length; i++) {
                alphabet[input[i] - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int i = 0; i < input.length; i++) {
                if (alphabet[input[i] - 'a'] < k)
                    continue;

                int cnt = 1;
                for (int l = i + 1; l < input.length; l++) {
                    if (input[i] == input[l])
                        cnt++;
                    if (cnt == k) {
                        min = Math.min(min, l - i + 1);
                        max = Math.max(max, l - i + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) {
                bw.append(-1 + "\n");
            }
            else {
                bw.append(min + " " + max + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

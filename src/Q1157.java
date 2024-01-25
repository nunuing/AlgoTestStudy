import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();

        int gap = (int)('a' - 'A');
        int length = (int) ('Z' - 'A') + 1;
        int[] cnt = new int[length];
        for (int i = 0; i < word.length; i++) {
            if (word[i] >= 'a') {
                word[i] = (char)(word[i] - gap);
            }
            cnt[(int)(word[i] - 'A')]++;
        }

        int max = 0;
        char maxChar = 'A';
        for (int i = 0; i < length; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                maxChar = (char) ('A' + i);
            }
            else if (max == cnt[i]) {
                maxChar = '?';
            }
        }
        System.out.println(maxChar);
    }
}

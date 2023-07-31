import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Q1339 {
    static int[] mapping;
    static char[][] words;
    static boolean[] existed, used;
    static LinkedList<Integer> list;
    static  int n, length = 'Z' - 'A' + 1, cnt, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new char[n][];

        existed = new boolean[length];
        cnt = 0;
        list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().toCharArray();
            for (int j = 0; j < words[i].length; j++) {
                int temp = words[i][j] - 'A';
                if (!existed[temp]) {
                    cnt++;
                    existed[temp] = true;
                    list.add(temp);
                }
            }
        }
        br.close();

        mapping = new int[length];
        Arrays.fill(mapping, -1);
        answer = 0;
        used = new boolean[10];
        for (int temp : list) {
            match(0 , temp);
        }

        System.out.println(answer);
    }
    static void match (int mNum, int now){
        if (mNum == cnt) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int k = 1;
                for (int j = words[i].length - 1; j >= 0; j--) {
                    int temp = mapping[words[i][j] - 'A'];
                    sum += temp * k;
                    k *= 10;
                }
            }

            answer = answer >= sum ? answer : sum;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (existed[now] && !used[i]) {
                mapping[now] = i;
                used[i] = true;
                match(mNum + 1, now + 1);
                used[i] = false;
            }
        }
    }
}

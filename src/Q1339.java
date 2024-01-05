import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] words = new char[n][];

        int length = 'Z' - 'A' + 1;
        int[] existed = new int[length];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().toCharArray();
            int ten = 1;
            for (int j = words[i].length - 1; j >= 0; j--) {
                int temp = words[i][j] - 'A';
                    cnt++;
                    existed[temp] += ten;
                    ten *= 10;
            }
        }
        br.close();

        int[][] info = new int[cnt][2];
        int idx = 0, answer = 0;
        for (int i = 0; i < length; i++) {
            if (existed[i] > 0) {
                info[idx++] = new int[] {i, existed[i]};
            }
        }
        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int i = 9;
        for (int j = 0; j < cnt; j++) {
            answer += info[j][1] * i;
            i--;
        }
        System.out.println(answer);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17140 {
    static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new int[101][101];
        for (int i = 1; i <= 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = 3;        //행 길이 기록
            for (int j = 1; j <= 3; j++) {
                a[0][j] = 3;    //열 길이 기록
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time++ <= 100) {
            if (a[r][c] == k)
                break;

        }
        if (time > 100) {
            System.out.println(-1);
        }
        else {
            System.out.println(time);
        }
    }
    static void calRow(){
        PriorityQueue<Number> queue = new PriorityQueue<>();
        for (int i = 1; i < a[0][1]; i++) {
            int[] cnt = new int[101];
            for (int j = 0; j < a[i][0]; j++) {
                cnt[a[i][j]]++;
            }
        }
    }
    static void calCol() {

    }
    static class Number implements Comparable<Number> {
        public int val;
        public int cnt;
        public Number(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) {
            if (this.cnt != o.cnt) {
                return this.cnt - o.cnt;
            }
            return this.val - o.val;
        }
    }
}

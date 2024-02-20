import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17140 {
    static int[][] a;
    static int rLen, cLen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new int[101][101];
        for (int i = 1; i <= 3 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int time = 0;
        rLen = 3;
        cLen = 3;
        while (true) {
            if (a[r][c] == k) {
                System.out.println(time);
                break;
            }

            if (time >= 100) {
                System.out.println(-1);
                break;
            }
            if (cLen >= rLen) {
                calRow();
            }
            else
                calCol();
            time++;
        }
    }
    static void calRow(){
        PriorityQueue<Number> queue = new PriorityQueue<>();
        for (int i = 1; i <= cLen; i++) {
            HashMap<Integer, Integer> numbers = new HashMap<>();
            for (int j = 1; j <= rLen; j++) {
                int temp = a[i][j];
                if (temp == 0)
                    continue;
                if (numbers.containsKey(temp)) {
                    int tcnt = numbers.get(temp) + 1;
                    numbers.replace(temp, tcnt);
                }
                else {
                    numbers.put(temp, 1);
                }
            }
            numbers.forEach((k, v) -> queue.add(new Number(k, v)));

            int length = 1;
            while (!queue.isEmpty()) {
                Number now = queue.poll();
                a[i][length++] = now.val;
                a[i][length++] = now.cnt;
             }

            rLen = Math.max(length, rLen);
            for (int k = length; k < 101; k++) {
                a[i][k] = 0;
            }
        }
    }
    static void calCol() {
        PriorityQueue<Number> queue = new PriorityQueue<>();
        for (int i = 1; i <= rLen; i++) {
            HashMap<Integer, Integer> numbers = new HashMap<>();
            for (int j = 1; j <= cLen; j++) {
                int temp = a[j][i];
                if (temp == 0)
                    continue;
                if (numbers.containsKey(temp)) {
                    int tcnt = numbers.get(temp) + 1;
                    numbers.replace(temp, tcnt);
                }
                else {
                    numbers.put(temp, 1);
                }
            }
            numbers.forEach((k, v) -> queue.add(new Number(k, v)));

            int length = 1;
            while (!queue.isEmpty()) {
                Number now = queue.poll();
                a[length++][i] = now.val;
                a[length++][i] = now.cnt;
            }

            cLen = Math.max(length, cLen);
            for (int k = length; k < 101; k++) {
                a[k][i] = 0;
            }
        }
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

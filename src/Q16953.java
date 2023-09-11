import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Queue<Number> queue = new LinkedList<>();
        queue.offer(new Number(a, 1));
        while (!queue.isEmpty()) {
            Number now = queue.poll();
            if (now.val == b) {
                System.out.println(now.cal);
                return;
            }

            for (int i = 0; i < 2; i++) {
                long temp = now.val;
                int cal = now.cal;
                if (i == 0) {
                    temp *= 2;
                }
                else {
                    temp = (temp * 10) + 1;
                }
                if (temp < 0 || temp > b)
                    continue;
                queue.offer(new Number(temp, cal + 1));
            }
        }
        System.out.println(-1);
    }
    static class Number {
        public long val;
        public int cal;
        public Number(long val, int cal) {
            this.val = val;
            this.cal = cal;
        }
    }
}

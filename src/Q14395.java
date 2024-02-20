import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());


        Number now = new Number(s, "");
        Set<Long> check = new HashSet<>();

        Queue<Number> queue = new LinkedList<>();
        check.add(s);
        queue.offer(now);
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (now.val == t) {
                if (now.cal.length() == 0) {
                    System.out.println(0);
                }
                else {
                    System.out.println(now.cal);
                }
                return;
            }
            for (int i = 0; i < 4; i++) {
                long temp = now.val;
                String str = now.cal;
                if (i == 0) {       //*
                    temp = temp * temp;
                    str += '*';
                }
                else if (i == 1) {  //+
                    temp = temp + temp;
                    str += '+';
                }
                else if (i == 2) {  //-
                    temp = 0;
                    str += '-';
                }
                else if (i == 3 && temp != 0) {  ///
                    temp = 1;
                    str += '/';
                }
                else if (i == 3 && temp == 0)
                    continue;

                if (!check.contains(temp)) {
                    queue.offer(new Number(temp, str));
                    check.add(temp);
                }

            }
        }
        System.out.println(-1);
    }
    static class Number {
        public long val;
        public String cal;
        public Number(long val, String cal) {
            this.val = val;
            this.cal = cal;
        }
    }
}

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        String[] orders = {"D", "S", "L", "R"};

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10001];

            Queue<Register> queue = new LinkedList<>();
            Register now = new Register(a);
            queue.offer(now);
            visited[now.val] = true;
            while (!queue.isEmpty()) {
                now = queue.poll();

                if (now.val == b) {
                    break;
                }
                for (int i = 0; i < orders.length; i++) {
                    int val = now.val;
                    if (i == 0) {           //D
                        val *= 2;
                        if (val > 9999)
                            val %= 10000;
                    }
                    else if (i == 1) {      //S
                        val -= 1;
                        if (val < 0)
                            val = 9999;
                    }
                    else {      //L or R
                        int temp = now.val;
                        int d4 = temp % 10;
                        temp /= 10;

                        int d3 = temp % 10;
                        temp /= 10;

                        int d2 = temp % 10;
                        temp /= 10;

                        int d1 = temp;

                        if (i == 2)
                            val = (d2 * 1000) + (d3 * 100) + (d4 * 10) + d1;
                        else
                            val = (d4 * 1000) + (d1 * 100) + (d2 * 10) + d3;
                    }
                    if (!visited[val]) {
                        queue.offer(new Register(val, now.orders + orders[i]));
                        visited[val] = true;
                    }
                }
            }

            if (!visited[b]) {
                bw.append(-1  + "\n");
            }
            else {
                bw.append(now.orders + "\n");
            }
        }
        br.close();

        bw.flush();
        bw.close();
    }
    static class Register {
        public int val;
        public String orders;
        public Register(int val) {
            this.val = val;
            orders = "";
        }
        public Register(int val, String orders) {
            this.val = val;
            this.orders = orders;
        }
    }
}

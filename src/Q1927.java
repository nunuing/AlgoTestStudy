import java.io.*;
import java.util.PriorityQueue;

public class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (n-- > 0) {
            int order = Integer.parseInt(br.readLine());
            if (order == 0) {
                if (queue.isEmpty())
                    bw.append(0 + "\n");
                else
                    bw.append(queue.poll() + "\n");
            }
            else {
                queue.offer(order);

            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}

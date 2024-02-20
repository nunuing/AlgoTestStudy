import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] weights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Truck> queue = new LinkedList<>();
        int time = 2;
        int sum = weights[0];
        int next = 1;
        queue.offer(new Truck(0, w + 1));
        while (next < n) {
            while (!queue.isEmpty() && queue.peek().time == time) {
                Truck temp = queue.poll();
                sum -= weights[temp.num];
            }

            if (queue.size() <= w && sum + weights[next] <= l) {
                queue.offer(new Truck(next, time + w));
                sum += weights[next++];
            }
            time++;
        }

        while (!queue.isEmpty()) {
            time = queue.poll().time;
        }
        System.out.println(time);
    }

    static class Truck {
        public int num;
        public int time;

        public Truck(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}

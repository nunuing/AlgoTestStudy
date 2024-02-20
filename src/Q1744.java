import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp <= 0)
                minus.offer(temp);
            else
                plus.offer(temp);
        }


        long answer = 0;
        while (plus.size() >= 2) {
            int first = plus.poll();
            int second = plus.poll();

            if (first + second > first * second)
                answer += (first + second);
            else
                answer += (first * second);
        }
        if (!plus.isEmpty())
            answer += plus.poll();

        while (minus.size() >= 2) {
            int first = minus.poll();
            int second = minus.poll();

            if (first + second > first * second)
                answer += (first + second);
            else
                answer += (first * second);
        }
        if (!minus.isEmpty()) {
            answer += minus.poll();
        }

        System.out.println(answer);
    }
}

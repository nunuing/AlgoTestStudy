
import java.util.PriorityQueue;

public class P31 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
    static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2) {
               return -1;
            }

            int temp1 = pq.poll();
            int temp2 = pq.poll();

            int nScovile = temp1 + (temp2 * 2);
            pq.offer(nScovile);
            answer++;
        }
        return answer;
    }
}

import java.util.Collections;
import java.util.PriorityQueue;

public class P39 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        System.out.println(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }
    static public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String[] input = operations[i].split(" ");
            if (input[0].equals("D")) {
                if (input[1].equals("1")) {
                    if (!maxQueue.isEmpty()) {
                        int tMax = maxQueue.poll();
                        minQueue.remove(tMax);
                    }
                }
                else {
                    if (!minQueue.isEmpty()) {
                        int tMin = minQueue.poll();
                        maxQueue.remove(tMin);
                    }
                }
            }
            else {
                int temp = Integer.parseInt(input[1]);
                maxQueue.add(temp);
                minQueue.add(temp);
            }
        }
        if (maxQueue.isEmpty()) {
            return new int[]{0, 0};
        }
        else {
            return new int[] {maxQueue.peek(), minQueue.peek()};
        }
    }
}

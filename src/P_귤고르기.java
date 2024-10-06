import java.util.HashMap;
import java.util.PriorityQueue;

public class P_귤고르기 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    static public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> tangerines = new HashMap<>();
        for (int i : tangerine) {
            if (tangerines.containsKey(i)) {
                int temp = tangerines.get(i);
                tangerines.replace(i, temp + 1);
            }
            else {
                tangerines.put(i, 1);
            }
        }

        PriorityQueue<Tangerine> q = new PriorityQueue<>();
        for (int key : tangerines.keySet()) {
            q.add(new Tangerine(key, tangerines.get(key)));
        }

        while (!q.isEmpty()) {
            if (k <= 0)
                break;

            Tangerine now = q.poll();
            answer++;
            if (k >= now.cnt) {
                k -= now.cnt;
            }
            else {
                k = 0;
            }
        }
        return answer;
    }

    static class Tangerine implements Comparable<Tangerine>{
        public int size;
        public int cnt;

        public Tangerine(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Tangerine o) {
            return o.cnt- this.cnt;
        }
    }
}


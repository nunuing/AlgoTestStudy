import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
        System.out.println(solution(new int[][] {{0, 3}, {10, 1}}));
        System.out.println(solution(new int[][] {{7, 8}, {3, 5}, {9, 6}}));
        System.out.println(solution(new int[][] {{1, 4}, {7, 9}, {1000, 3}}));
        System.out.println(solution(new int[][] {{0, 1}, {2, 2}, {2, 3}}));

    }
    static public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];       //오름차순
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int sec = 0, pos = 0;
        while (pos < jobs.length  || !pq.isEmpty()) {
            for (int i = pos; i < jobs.length; i++) {
                if (jobs[i][0] <= sec) {
                    pq.offer(jobs[i]);
                    pos = i + 1;
                }
                else if (jobs[i][0] > sec)
                    break;
            }

            if (pq.isEmpty()) {
                sec++;
                continue;
            }

            int[] now = pq.poll();
            answer += ((sec - now[0])+ now[1]);
            sec += now[1];

        }
        return answer / jobs.length;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class P23 {
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
    public static int solution(String begin, String target, String[] words) {
        int tIdx = -1;
        for (int i = 0; i < words.length; i++) {
            if (target.compareTo(words[i]) == 0) {
                tIdx = i;
                break;
            }
        }
        if (tIdx == -1)
            return 0;

        int[] visited = new int[words.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == 0) {
                int check = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if (begin.charAt(j) != words[i].charAt(j)) {
                        check++;
                        if (check > 1)
                            break;
                    }
                }
                if (check == 1) {
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }

        int now;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (begin.equals(target)) {
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i] == 0) {
                    int check = 0;
                    for (int j = 0; j < words[now].length(); j++) {
                        if (words[now].charAt(j) != words[i].charAt(j)) {
                            check++;
                            if (check > 1)
                                break;
                        }
                    }
                    if (check == 1) {
                        visited[i] = visited[now] + 1;
                        queue.offer(i);
                    }
                }
            }
        }
        return visited[tIdx];
    }
}

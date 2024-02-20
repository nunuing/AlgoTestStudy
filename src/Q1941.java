import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1941 {
    static char[][] students;
    static int[] result = new int[7];
    static boolean[] visited = new boolean[7];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        students = new char[5][5];
        for (int i = 0; i < 5; i++) {
            students[i] = br.readLine().toCharArray();
        }

        answer = 0;
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int now, int cntY) {
        if (cntY >= 4)
            return;
        if (depth == 7) {
            visited = new boolean[7];
            check();
            return;
        }
        for (int i = now; i < 25; i++) {
            result[depth] = i;
            if (students[i / 5][i % 5] == 'Y')
                dfs(depth + 1, i + 1, cntY + 1);
            else
                dfs(depth + 1, i + 1, cntY);

        }
    }

    static void check() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{result[0] / 5, result[0] % 5});
        visited[0] = true;

        int conn = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];

                if (tx < 0 || tx >= 5 || ty < 0 || ty >= 5)
                    continue;

                int temp = (tx * 5) + ty;
                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && result[j] == temp) {
                        queue.offer(new int[]{tx, ty});
                        visited[j] = true;
                        conn++;
                    }
                }
            }
        }
        if (conn == 7)
            answer++;
    }
}

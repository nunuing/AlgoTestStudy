import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1800 {
    static int n, p, k;
    static int[][] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        computers = new int[n + 1][n + 1];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            computers[c1][c2] = price;
            computers[c2][c1] = price;
        }

        int left = 0;
        int right = 10000000;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean check(int price) {
        Queue<Computer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        queue.offer(new Computer(1, 1));
        visited[1] = 0;
        while (!queue.isEmpty()) {
            Computer now = queue.poll();
            if (now.num == n) {
                if (visited[n] == price)
                    return true;
                else
                    return false;
            }

            int nn = now.num;
            int nc = now.cables;
            int np = visited[now.num];
            for (int i = 1; i <= n; i++) {
                if (computers[nn][i] != 0 && visited[i] == -1) {
                    if (nc > k) {
                        visited[i] = Math.max(visited[i], computers[nn][i]);
                    }
                    else {
                        visited[i] = 0;
                    }
                    queue.offer(new Computer(i, nc + 1));
                }
            }
        }
        return false;
    }
    static class Computer {
        public int num;
        public int cables;
        public Computer(int num, int cables) {
            this.num = num;
            this.cables = cables;
        }
    }
}


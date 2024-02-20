import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16236 {
    static Pair shark;
    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] sea = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    sea[i][j] = 0;
                    shark = new Pair(i, j, 0);
                }
            }
        }
        br.close();

        int time = 0;
        int eat = 0;
        int size = 2;
        while (true) {
            PriorityQueue<Pair> fishes = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.dist == o2.dist) {
                        if (o1.x != o2.x)
                            return Integer.compare(o1.x, o2.x);
                        return Integer.compare(o1.y, o2.y);
                    }
                    return Integer.compare(o1.dist, o2.dist);
                }
            });

            boolean[][] visited = new boolean[n][n];

            fishes.offer(new Pair(shark.x, shark.y, 0));
            visited[shark.x][shark.y] = true;

            boolean check = false;
            while (!fishes.isEmpty()) {
                shark = fishes.poll();

                if (sea[shark.x][shark.y] != 0 && sea[shark.x][shark.y] < size) {
                    sea[shark.x][shark.y] = 0;
                    eat++;
                    time+= shark.dist;
                    check = true;
                    break;
                }

                for (int i = 0; i < mx.length; i++) {
                    int tx = shark.x + mx[i];
                    int ty = shark.y + my[i];
                    int dist = shark.dist;

                    if (tx < 0 || tx >= n || ty < 0 || ty >= n)
                        continue;

                    if (!visited[tx][ty] && sea[tx][ty] <= size){
                        fishes.offer(new Pair(tx, ty, dist + 1));
                        visited[tx][ty] = true;
                    }
                }
            }
            if (!check)
                break;
            if (size == eat) {
                size++;
                eat = 0;
            }
        }
        System.out.println(time);
    }
    static class Pair {
        public int x;
        public int y;
        public int dist;
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

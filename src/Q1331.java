import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[6][6];
        char[] start = br.readLine().toCharArray();
        int nx = start[0] - 'A';
        int ny = start[1] - '1';
        visited[nx][ny] = true;

        for (int i = 1; i < 36; i++) {
            char[] input = br.readLine().toCharArray();
            int x = input[0] - 'A';
            int y = input[1] - '1';

            if (visited[x][y]) {
                System.out.println("Invalid");
                return;
            }
            if ((Math.abs(nx - x) == 2 && Math.abs(ny - y) == 1) || (Math.abs(nx - x) == 1 && Math.abs(ny - y) == 2)) {
                visited[x][y] = true;
                nx = x;
                ny = y;
            }
            else {
                System.out.println("Invalid");
                return;
            }
        }
        int sx = start[0] - 'A';
        int sy = start[1] - '1';
        if ((Math.abs(nx - sx) == 2 && Math.abs(ny - sy) == 1) || (Math.abs(nx - sx) == 1 && Math.abs(ny - sy) == 2)) {
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    if (!visited[i][j]) {
                        System.out.println("Invalid");
                        return;
                    }
                }
            }
            System.out.println("Valid");
        }
        else
            System.out.println("Invalid");
    }
}

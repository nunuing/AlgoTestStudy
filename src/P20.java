public class P20 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }
    public static int solution(String dirs) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int nx = 5;
        int ny = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int idx = 0;
            int reverse = 1;
            if (dir == 'L') {
                idx = 1;
                reverse = 3;
            }
            else if (dir == 'R') {
                idx = 3;
                reverse = 1;
            }
            else if (dir == 'U') {
                idx = 0;
                reverse = 2;
            }
            else if (dir == 'D') {
                idx = 2;
                reverse = 0;
            }

            int tx = nx + dx[idx];
            int ty = ny + dy[idx];
            if (tx < 0 || tx > 10 || ty < 0 || ty > 10)
                continue;

            if (!visited[ty][tx][idx]){
                answer++;
                visited[ty][tx][idx] = true;
                visited[ny][nx][reverse] = true;
            }

            nx = tx;
            ny = ty;
        }
        return answer;
    }
}

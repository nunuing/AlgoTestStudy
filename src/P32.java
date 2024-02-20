import java.util.Arrays;

public class P32 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }
    static public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int cctv = routes[0][1];
        for (int i = 1; i < routes.length; i++){
            if (cctv < routes[i][0]) {
                answer++;
                cctv = routes[i][1];
            }
        }
        return answer;
    }
}

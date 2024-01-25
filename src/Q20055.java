import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] conveyor = new int[2 * n + 1];
        boolean[] robot = new boolean[2 * n + 1];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < conveyor.length; i++) {
            conveyor[i] = Integer.parseInt(st.nextToken());
            if (conveyor[i] == 0)
                cnt++;
        }

        if (cnt >= k) {
            System.out.println(1);
            return;
        }
        int stage = 1;
        while (true) {
            //벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전한다. -> 이때 내리는 위치에서는 로봇이 내려짐
            int temp = conveyor[conveyor.length - 1];
            boolean tb = robot[robot.length - 1];
            for (int i = conveyor.length - 1; i > 1; i--) {
                conveyor[i] = conveyor[i - 1];
                robot[i] = robot[i - 1];
            }
            conveyor[1] = temp;
            robot[1] = tb;

            robot[n] = false;

            //가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동 -> 이동했을때 위치가 n이면 로봇 내림
            for (int i = n - 1; i > 0; i--) {
                if (robot[i] && !robot[i + 1]) {
                    if (conveyor[i + 1] > 0) {
                        robot[i + 1] = true;
                        robot[i] = false;
                        conveyor[i + 1]--;
                    }
                }
            }

            robot[n] = false;

            //올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올림
            if (!robot[1] && conveyor[1] > 0) {
                robot[1] = true;
                conveyor[1]--;
            }
            //내구도가 0인 칸 확인
            cnt = 0;
            for (int i = 1; i < conveyor.length; i++) {
                if (conveyor[i] == 0) {
                    cnt++;
                }
            }
            if (cnt >= k)
                break;
            stage++;
        }

        System.out.println(stage);
    }
}

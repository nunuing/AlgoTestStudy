import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14891 {
    static boolean[][] wheels, cWheels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new boolean[5][8];
        for (int i = 1; i < wheels.length; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < wheels[0].length; j++) {
                wheels[i][j] = input[j] == '1' ? true : false;
            }
        }

        int k = Integer.parseInt(br.readLine());
        cWheels = new boolean[5][8];
        while (k-- > 0) {
            for (int i = 1; i <wheels.length; i++){
                for (int j = 0; j < wheels[0].length; j++) {
                    cWheels[i][j] = wheels[i][j];
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            rotation(true, true, d, r);
        }
        br.close();

       int answer = 0;
       if (wheels[1][0])
           answer += 1;
       if (wheels[2][0])
           answer += 2;
       if (wheels[3][0])
           answer += 4;
       if(wheels[4][0])
           answer += 8;

        System.out.println(answer);
    }
    static void rotation(boolean lCheck, boolean rCheck, int d, int num) {
        if (lCheck) {
            if (num - 1 < 0) {
                lCheck = false;
            } else if (cWheels[num - 1][2] == cWheels[num][6]) {
                lCheck = false;
            }
        }
        if (rCheck) {
            if (num + 1 > 4) {
                rCheck = false;
            } else if (cWheels[num][2] == cWheels[num][6]) {
                rCheck = false;
            }
        }

        int l = wheels[num].length;
        if (d == 1){            //시계 방향
            boolean temp = wheels[num][l - 1];
            for (int i = l - 1; i > 0; i--) {
                wheels[num][i] = wheels[num][i - 1];
            }
            wheels[num][0] = temp;
        }
        else {                  //반시계 방향
            boolean temp = wheels[num][0];
            for (int i = 0; i < l - 1; i++) {
                wheels[num][i] = wheels[num][i + 1];
            }
            wheels[num][l - 1] = temp;
        }
        if (lCheck) {
            rotation(true, false, -1 * d, num - 1);
        }
        if (rCheck) {
            rotation(false, true, -1 * d, num + 1);
        }
    }
}

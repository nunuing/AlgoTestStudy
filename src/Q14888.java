import java.io.*;
import java.util.StringTokenizer;

public class Q14888 {
    static int n, minSum, maxSum;
    static int[] inputs, cal, chosen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        inputs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            inputs[i] = Integer.parseInt(st.nextToken());

        cal = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cal.length; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        minSum = Integer.MAX_VALUE;
        maxSum = Integer.MIN_VALUE;
        chosen = new int[n];
        choose(1);

        bw.append(maxSum + "\n" + minSum);
        bw.flush();
        bw.close();
    }
    static void choose(int cnt) {
        if (cnt >= n) {
            //계산
            int sum = inputs[0];
            for (int i = 1; i < n; i++) {
                if (chosen[i] == 0) {               //더하기
                    sum += inputs[i];
                }
                else if(chosen[i] == 1) {           //빼기
                    sum -= inputs[i];
                }
                else if(chosen[i] == 2) {           //곱하기
                    sum *= inputs[i];
                }
                else {                              //나누기
                    if (inputs[i] < 0) {
                        int temp = sum / Math.abs(inputs[i]);
                        sum = temp * -1;
                    }
                    else {
                        sum /= inputs[i];
                    }
                }
            }
                minSum = minSum < sum ? minSum : sum;
                maxSum = maxSum > sum ? maxSum : sum;
            return;
        }
        for (int i = 0; i < cal.length; i++) {
            if (cal[i] > 0) {
                chosen[cnt] = i;
                cal[i]--;
                choose(cnt + 1);
                cal[i]++;
            }
        }
    }
}

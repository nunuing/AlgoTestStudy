import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] now1 = new int[n];

        char[] temp = br.readLine().toCharArray();
        for (int j = 0; j < n; j++) {
            now1[j] = temp[j] - '0';
        }

        int[] target = new int[n];
        temp = br.readLine().toCharArray();
        for (int j = 0; j < n; j++) {
            target[j] = temp[j] - '0';
        }

        int[] now2 = Arrays.copyOf(now1, n);
        now2[0] = 1 - now2[0];
        now2[1] = 1 - now2[1];
        int answer1 = solution(n, now1, target);
        int answer2 = solution(n, now2, target);
        if (answer2 != -1)
            answer2++;

        if (answer1 == -1) {
            System.out.println(answer2);
        }
        else if (answer2 == -1) {
            System.out.println(answer1);
        }
        else {
            System.out.println(Math.min(answer1, answer2));
        }

    }
    static int solution(int n, int[] arrA, int[] arrB) {
        int answer = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (arrA[i] != arrB[i]) {
                answer++;
                arrA[i] = 1 - arrA[i];
                arrA[i + 1] = 1 - arrA[i + 1];
                if (i + 2 < n)
                    arrA[i + 2] = 1 - arrA[i + 2];
            }
        }
        if (check(arrA, arrB))
            return answer;
        else return -1;
    }
    static boolean check(int[] arrA, int[] arrB) {
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] != arrB[i])
                return false;
        }
        return true;
    }
}

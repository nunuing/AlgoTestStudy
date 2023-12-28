import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int pos = n - 1;
        while(pos > 0 && data[pos - 1] < data[pos]){
            pos--;
        }

        int mPos = pos;
        if (pos > 0) {
            for (int i = n - 1; i >= pos; i--) {
                if (data[i] < data[pos - 1]) {
                    mPos = i;
                    break;
                }
            }
            int temp = data[mPos];
            data[mPos] = data[pos - 1];
            data[pos - 1] = temp;

            reverse(data, pos, n - 1);

            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    static void reverse(int[] data, int str, int end) {
        int[] temp = new int[end - str + 1];
        int j = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i] = data[str + j];
            j++;
        }

        for (int i = 0; i < temp.length; i++) {
            data[str + i] = temp[i];
        }
    }
}

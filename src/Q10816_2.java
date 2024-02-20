import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816_2 {
    static int[] cards;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int lower = lowerBound(target);
            int upper = upperBound(target);
            sb.append(upper - lower + " ");
        }
        System.out.println(sb);
    }
    static int lowerBound(int target) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    static int upperBound(int target) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return right;
    }
}

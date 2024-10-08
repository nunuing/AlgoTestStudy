import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       //듣도 못한 사람
        int m = Integer.parseInt(st.nextToken());       //보도 못한 사람

        HashSet<String> names = new HashSet<>();
        for (int i = 0; i < n; i++) {
            names.add(br.readLine());
        }
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            if (names.contains(temp)) {
                answer.add(temp);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (String str : answer) {
            System.out.println(str);
        }
    }
}

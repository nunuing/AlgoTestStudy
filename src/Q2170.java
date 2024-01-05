import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Line> lines = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            lines.add(new Line(str, dest));
        }
        Collections.sort(lines);

        int answer = lines.get(0).d - lines.get(0).s;
        int prev = lines.get(0).d;
        for (Line l : lines) {
            if (prev >= l.d) {

            }
            else if (prev < l.d && prev > l.s) {
                answer += l.d - prev;
                prev = l.d;
            }
            else {
                answer += (l.d - l.s);
                prev = l.d;
            }

        }
        System.out.println(answer);
    }
    static class Line implements Comparable<Line>{
        public int s;
        public int d;
        public Line(int s, int d) {
            this.s = s;
            this.d = d;
        }

        @Override
        public int compareTo(Line l) {
            int rs = this.s - l.s;
            if(rs == 0) rs = this.d - l.d;
            return rs;
        }
    }
}

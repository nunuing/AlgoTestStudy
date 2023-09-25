import java.io.*;
import java.util.StringTokenizer;

public class Q19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Level[] levels = new Level[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            levels[i] = new Level(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            int score = Integer.parseInt(br.readLine());
            int str = 0;
            int end = n - 1;
            while (str <= end) {
                int mid = (str + end) / 2;
                if (score > levels[mid].score)
                    str = mid + 1;
                else
                    end = mid - 1;
            }
            bw.append(levels[str].name + "\n");
        }
        br.close();
        bw.flush();
    }
    static class Level {
        public String name;
        public int score;
        public Level(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}

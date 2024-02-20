import java.io.*;
import java.util.StringTokenizer;

public class Q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            students[i] = new Student(w, h);
        }
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[i].height < students[j].height && students[i].weight < students[j].weight) {
                    students[i].cnt++;
                }
                else if (students[i].height > students[j].height && students[i].weight > students[j].weight) {
                    students[j].cnt++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
            bw.append((students[i].cnt + 1) + " ");
        }
        bw.flush();
        bw.close();
    }
    static class Student {
        public int weight;
        public int height;
        public int cnt = 0;
        public Student(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}

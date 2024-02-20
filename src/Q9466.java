import java.io.*;
import java.util.StringTokenizer;

public class Q9466 {
    static int[] students;
    static boolean[] visited, done;
    static int n, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (tc-- > 0) {
            n =  Integer.parseInt(br.readLine());
            students = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            answer = n;
            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            bw.append(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int pos) {
        if (done[pos])
            return;
        if (visited[pos]) {
            answer--;
            done[pos] = true;
        }
        visited[pos] = true;
        dfs(students[pos]);
        done[pos] = true;
        visited[pos] = false;

    }
}

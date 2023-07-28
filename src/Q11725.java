import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q11725 {
    static LinkedList<Integer>[] tree;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new LinkedList<>();

        StringTokenizer st;
        for (int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            tree[first].add(second);
            tree[second].add(first);
        }
        br.close();

        parents = new int[n + 1];
        Arrays.fill(parents, -1);
        visit(1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 2; i <= n; i++)
            bw.append(parents[i] + "\n");

        bw.flush();
        bw.close();
    }
    static void visit(int now){
        for (int node : tree[now]){
            if (parents[node] == -1){
                parents[node] = now;
                visit(node);
            }
        }
    }
}

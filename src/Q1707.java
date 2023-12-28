import java.io.*;
import java.util.*;

public class Q1707 {
    static LinkedList<Integer>[] map;
    static int[] numbering;
    static int v;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map = new LinkedList[v + 1];
            for (int i = 0; i <= v; i++) {
                map[i] = new LinkedList<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                map[first].add(second);
                map[second].add(first);
            }
            isBinary();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void isBinary() throws IOException {
        numbering = new int[v + 1];
        Arrays.fill(numbering, 0);

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= v; i++) {
            if(numbering[i] != 0)
                continue;
            stack.push(i);
            numbering[i] = 1;
            while (!stack.empty()) {
                int now = stack.pop();
                for (int node : map[now]) {
                    if (numbering[node] == 0) {
                        stack.push(node);
                    }
                    if (numbering[node] == numbering[now]) {
                        bw.append("NO\n");
                        return;
                    }
                    if (numbering[node] == 0 && numbering[now] == 1) {
                        numbering[node] = 2;
                    } else if (numbering[node] == 0 && numbering[now] == 2) {
                        numbering[node] = 1;
                    }
                }
            }
        }
        bw.append("YES\n");
    }

}

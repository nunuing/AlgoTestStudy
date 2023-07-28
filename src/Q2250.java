import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2250 {
    static Node[] tree;
    static LinkedList<Integer>[] levels;
    static int maxHeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];
        levels = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new Node(i);
            levels[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (l != -1){
                tree[v].left = l;
                tree[l].parent = v;
            }
            if (r != -1) {
                tree[v].right = r;
                tree[r].parent = v;
            }

        }
        br.close();

        int root = 0;
        for (int i = 1; i <= n; i++) {
            if(tree[i].parent == -1){
                root = i;
                break;
            }
        }

        maxHeight = 0;
        inorder(root, 1);

        int answer = maxHeight;
        int diff = 0;
        for (int i = maxHeight - 1; i >= 1; i--){
            int size = levels[i].size();
            int temp = levels[i].get(size - 1) - levels[i].get(0) + 1;
            if (diff <= temp){
                answer = i;
                diff = temp;
            }
        }
        System.out.println(answer + " " + diff);
    }
    static void inorder(int now, int height) {
        if(tree[now].left != -1){
            inorder(tree[now].left, height + 1);
        }
        maxHeight = maxHeight >= height ? maxHeight : height;
        levels[height].add(now);
        if(tree[now].right != -1){
            inorder(tree[now].right, height + 1);
        }

    }

    static class Node {
        public int val;
        public int left = -1;
        public int right = -1;
        public int parent = -1;

        public Node(int v) {
            val = v;
        }

        public Node(int v, int left, int right){
            val = v;
            this.left = left;
            this.right = right;
        }
    }
}

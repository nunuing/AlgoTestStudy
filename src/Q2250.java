import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2250 {
    static Node[] tree;
    static int maxHeight, cnt;
    static int[] maxLevel, minLevel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];
        maxLevel = new int[n + 1];
        minLevel = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new Node(i);
            maxLevel[i] = 0;
            minLevel[i] = n + 1;
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
        cnt = 1;
        inorder(root, 1);

        int answer = 1;
        int diff = maxLevel[answer] - minLevel[answer] + 1;
        for (int i = 2; i <= maxHeight; i++){
            int temp = maxLevel[i] - minLevel[i] + 1;
            if (diff < temp){
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
        minLevel[height] = Math.min(minLevel[height], cnt);
        maxLevel[height] = cnt;
        cnt++;
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

import java.io.*;
import java.util.StringTokenizer;

public class Q1991 {
    static Node[] tree;
    static int n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        tree = new Node[26];
        char val = 'A';
        for (int i = 0; i < 26; i++) {
            tree[i] = new Node(val++);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = st.nextToken().charAt(0) - 'A';
            char temp = st.nextToken().charAt(0);
            if (temp != '.') {
                tree[value].left = tree[temp - 'A'];
            }

            temp = st.nextToken().charAt(0);
            if (temp != '.') {
                tree[value].right = tree[temp - 'A'];
            }
        }
        br.close();

        preorder(tree[0]);
        bw.append("\n");

        inorder(tree[0]);
        bw.append("\n");

        postorder(tree[0]);

        bw.flush();
        bw.close();
    }

    static void preorder(Node now) throws IOException {
        if (now == null)
            return;

        bw.append(now.value);
        if (now.left != null)
            preorder(now.left);
        if (now.right != null)
            preorder(now.right);

    }

    static void inorder(Node now) throws IOException {
        if (now == null)
            return;

        if (now.left != null)
            inorder(now.left);
        bw.append(now.value);
        if (now.right != null)
            inorder(now.right);

    }

    static void postorder(Node now) throws IOException {
        if (now == null)
            return;

        if (now.left != null)
            postorder(now.left);
        if (now.right != null)
            postorder(now.right);
        bw.append(now.value);

    }

    static class Node {
        public char value;
        public Node left;
        public Node right;

        public Node(char v) {
            value = v;
            left = null;
            right = null;
        }
    }
}

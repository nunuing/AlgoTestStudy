import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }

        while (linkedList.size() > 1) {
            linkedList.removeFirst();
            int temp = linkedList.removeFirst();
            linkedList.addLast(temp);
        }
        System.out.println(linkedList.getFirst());
    }
}

import java.util.HashSet;

public class P51 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }
    public static int solution(int[] elements) {
        int[] newElements = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
            newElements[i + elements.length] = elements[i];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j - i + 1 <= elements.length; j++) {
                if (j >= newElements.length)
                    break;
                sum += newElements[j];
                set.add(sum);
            }
        }
        return set.size();
    }
}

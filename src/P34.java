
public class P34 {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
    static public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] involved = new boolean[number.length()];
        int idx = 0;
        int next = 0;
        for (int i = 0; i + k < number.length(); i++) {
            int max = 0;
            for (int j = idx; j <= i + k; j++) {
                int current = number.charAt(j) - '0';
                if (max < current) {
                    max = current;
                    next = j;
                }
            }
            sb.append(max);
            idx = next + 1;
        }
        return sb.toString();
    }
}

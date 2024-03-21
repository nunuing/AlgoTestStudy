import java.util.HashMap;

public class P47 {
    public static void main(String[] args) {

    }
    static public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('R', 0);
        hashMap.put('T', 0);
        hashMap.put('C', 0);
        hashMap.put('F', 0);
        hashMap.put('J', 0);
        hashMap.put('M', 0);
        hashMap.put('A', 0);
        hashMap.put('N', 0);

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] > 3) {
                int temp = hashMap.get(survey[i].charAt(1));
                hashMap.replace(survey[i].charAt(1), temp +(choices[i] - 3));
            }
            else if (choices[i] < 3) {
                int temp = hashMap.get(survey[i].charAt(0));
                hashMap.replace(survey[i].charAt(0), temp +(4 - choices[i]));
            }
        }

        int r = hashMap.get('R');
        int t = hashMap.get('T');
        if (r < t) {
            answer += 'R';
        }
        else
            answer += 'R';

        int c = hashMap.get('C');
        int f = hashMap.get('F');
        if (c < f)
            answer += 'F';
        else answer += 'C';

        int j = hashMap.get('J');
        int m = hashMap.get('M');
        if (j < m)
            answer += 'M';
        else answer += 'J';

        int a = hashMap.get('A');
        int n = hashMap.get('N');
        if (a < n)
            answer += 'N';
        else answer += 'A';

        return answer;
    }
}

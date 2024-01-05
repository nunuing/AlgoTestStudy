import java.util.HashMap;
import java.util.Map;

public class P30 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"}));
    }
    static public String[] solution(String[] players, String[] callings) {
        String[] answer = players.clone();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < answer.length; i++) {
            map.put(answer[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int idx = map.get(callings[i]);
            String front = answer[idx - 1];
            answer[idx - 1] = answer[idx];
            answer[idx] = front;

            map.replace(callings[i], idx - 1);
            map.replace(front, idx);
        }

        return answer;
    }
}


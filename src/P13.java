import java.util.HashMap;

public class P13 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (hm.containsKey(participant[i])) {
                hm.replace(participant[i], hm.get(participant[i]) + 1);
            }
            else {
                hm.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            int temp = hm.get(completion[i]);
            if (temp == 1) {
                hm.remove(completion[i]);
            }
            else {
                hm.replace(completion[i], temp - 1);
            }
        }

        for (String str : hm.keySet()) {
            answer += str;
        }
        return answer;
    }
}

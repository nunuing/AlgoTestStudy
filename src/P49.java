import java.util.Arrays;
import java.util.HashSet;

public class P49 {
    static HashSet<String> hs;
    static boolean[] used;
    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
//        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    static public int solution(String[] user_id, String[] banned_id) {

        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }

        hs = new HashSet<>();
        used = new boolean[user_id.length];

        dfs(0, "", user_id, banned_id);

        return hs.size();
    }

    static void dfs(int depth, String str, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            String[] result = str.split(" ");
            Arrays.sort(result);
            String temp = "";
            for (String a : result) {
                temp += a;
            }

            hs.add(temp);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (used[i] || !user_id[i].matches(banned_id[depth]))
                continue;
            used[i] = true;
            dfs(depth + 1, str + user_id[i] + " ", user_id, banned_id);
            used[i] = false;
        }
    }
}

import java.util.Arrays;

public class L392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)){
                if(++i==s.length()) return true;
            }
        }
        return false;
    }
}

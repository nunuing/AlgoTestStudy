import java.util.HashMap;
import java.util.Iterator;

public class L409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int temp = map.get(chars[i]) + 1;
                map.remove(chars[i]);
                map.put(chars[i], temp);
            } else {
                map.put(chars[i], 1);
            }
        }

        int maxLength = 0;
        boolean hasOdd = false;
        Iterator<Character> keyIter = map.keySet().iterator();
        while (keyIter.hasNext()) {
            char key = keyIter.next();
            int val = map.get(key);
            if (val % 2 == 0)
                maxLength += val;
            else {
                hasOdd = true;
                maxLength += (val - 1);
            }
        }
        return hasOdd ? maxLength + 1 : maxLength;
    }
}

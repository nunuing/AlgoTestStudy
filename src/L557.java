public class L557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        int str = 0;
        int end = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                end = i - 1;
                sb.append(reverseString(s.substring(str, end + 1))).append(" ");
                str = i + 1;
            }
        }
        sb.append(reverseString(s.substring(str, s.length())));
        return sb.toString();
    }

    public static char[] reverseString(String s) {
        char[] chars = s.toCharArray();
        int str = 0;
        int end = chars.length - 1;
        while (str < end) {
            char temp = chars[str];
            chars[str] = chars[end];
            chars[end] = temp;

            str++;
            end--;
        }
        return chars;
    }
}

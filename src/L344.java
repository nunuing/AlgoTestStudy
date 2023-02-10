public class L344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int str = 0;
        int end = s.length - 1;

        while (str < end){
            char temp = s[str];
            s[str] = s[end];
            s[end] = temp;

            str++;
            end--;
        }
    }
}

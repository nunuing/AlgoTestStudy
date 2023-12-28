import java.util.Arrays;

public class L205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int[] diff = new int[128];
        for(int i = 0; i < diff.length; i++)
            diff[i] = 100;

        char[] answer = new char[sc.length];
        boolean[] check = new boolean[128];
        for(int i = 0; i < sc.length; i++){
            if(diff[sc[i]] == 100){
                if(check[tc[i]])
                    return false;
                diff[sc[i]] = tc[i] - sc[i];
                check[tc[i]] = true;
            }
            answer[i] = (char) (sc[i] + diff[sc[i]]);
        }

        if(Arrays.equals(answer, tc))
            return true;
        return false;
    }
}

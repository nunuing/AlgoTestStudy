public class P11 {
    static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] result = new char[4];
    static int answer;
    static int[] used = new int[10];
    static String pCheck, bCheck;
    public static void main(String[] args) {
        System.out.println(Integer.toString(012));
    }
    public static int solution(String phone_number, String birthday) {
        answer = 0;
        pCheck = phone_number.substring(5);
        bCheck = birthday;
        dfs(0);
        return  answer;
    }

    static public void dfs(int depth) {
        if (depth == 4) {
            int before = pCheck.indexOf(result[0]);

            if (before != -1) {
                boolean check = false;
                for (int i = 1; i < 4; i++) {
                    int now = pCheck.indexOf(result[i]);
                    if (now == -1) {
                        check = true;
                        break;
                    }
                    else if (before >= now) {
                        check = true;
                        break;
                    }
                    before = now;
                }
                if (!check)
                    return;
            }

            before = bCheck.indexOf(result[0]);
            if (before != -1) {
                boolean check = false;
                for (int i = 1; i < 4; i++) {
                    int now = bCheck.indexOf(result[i]);
                    if (now == -1) {
                        check = true;
                        break;
                    }
                    else if (before >= now) {
                        check = true;
                        break;
                    }
                    before = now;

                }
                if (!check)
                    return;
            }

            answer++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (used[i] < 2) {
                used[i]++;
                result[depth] =  numbers[i];
                dfs(depth + 1);
                used[i]--;
            }
        }
    }

}

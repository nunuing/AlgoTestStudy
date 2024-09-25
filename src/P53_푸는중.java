import java.util.HashMap;

public class P53_푸는중 {
    public static void main(String[] args) {

        System.out.println(solution("KAKAO"));
    }
    public static int[] solution(String msg) {
        int[] answer = {};
        HashMap<String, Integer> hashMap = new HashMap<>();
        //        1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        for (int i = 0; i < 'Z' - 'A' + 1; i++) {
            String temp = String.valueOf(((char)('A' + i)));
            hashMap.put(temp, i + 1);
        }
//        2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
        for (int i = 0; i < msg.length(); i++) {

        }
//        3. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
//        4. 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
//        5. 단계 2로 돌아간다.
        return answer;
    }
}

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P55 {
    public static void main(String[] args) {
//        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
//        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
//        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
//        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
//        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution( 0, new String[]{"Jeju", "Jeju"}));
    }
    static public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        int answer = 0;
        Queue<String> caches = new LinkedList<>();
        for (String temp : cities) {
            String now = temp.toLowerCase();
            if (caches.contains(now)) { //cache hit -> 1초
                answer += 1;
                caches.remove(now);
                caches.offer(now);
            }
            else {
                answer += 5;
                if (caches.size() >= cacheSize) {
                    caches.poll();
                }
                caches.offer(now);
            }
        }
        return answer;
    }
}

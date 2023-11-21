import java.util.*;

public class P26 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500}));
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> gList = new ArrayList<>();
        for (String str : hm.keySet()) {
            gList.add(str);
        }
        gList.sort(((o1, o2) -> hm.get(o2) - hm.get(o1)));

        ArrayList<Integer> answer = new ArrayList<>();
        for (String str : gList) {
            ArrayList<Song> sList = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (str.equals(genres[i])) {
                    sList.add(new Song(i, plays[i]));
                }
            }
            sList.sort((o1, o2) -> o2.plays - o1.plays);
            answer.add(sList.get(0).number);
            if (sList.size() > 1) {
                answer.add(sList.get(1).number);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    static class Song {
        public int number;
        public int plays;
        public Song(int number, int plays) {
            this.number = number;
            this.plays = plays;
        }
    }
}

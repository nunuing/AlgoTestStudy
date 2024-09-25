import java.util.*;

public class P54 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<Genre> gList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            Track temp = new Track(i, plays[i]);
            if (!hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], gList.size());
                Genre tgenre = new Genre(genres[i], plays[i]);
                tgenre.tracks.add(temp);
                gList.add(tgenre);
            }
            else {
                int pos = hashMap.get(genres[i]);
                Genre now = gList.get(pos);
                now.plays += plays[i];
                now.tracks.add(temp);
            }
        }
        Collections.sort(gList);

        ArrayList<Integer> answer = new ArrayList<>();
        for (Genre g : gList) {
            System.out.println(g.name);
            int cnt = 0;
            while (cnt++ < 2 && !g.tracks.isEmpty()) {
                answer.add(g.tracks.poll().idx);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    static class Genre implements Comparable<Genre>{
        String name;
        PriorityQueue<Track> tracks;
        int plays;

        public Genre(String name, int plays) {
            this.name = name;
            this.tracks = new PriorityQueue<>();
            this.plays = plays;
        }

        @Override
        public int compareTo(Genre g) {
            if (g.plays > this.plays)
                return 1;
            return -1;
        }
    }
    static class Track implements Comparable<Track>{
        int idx;
        int play;

        public Track(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(Track t) {
            if (t.play != this.play) {
                if (t.play > this.play)
                    return 1;
                else
                    return -1;
            }
            if (t.idx < this.idx)
                return 1;
            return -1;
        }
    }
}

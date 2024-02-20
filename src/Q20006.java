import java.io.*;
import java.util.*;

public class Q20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Room> rooms = new LinkedList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String nn = st.nextToken();

            boolean involved = false;
            for (Room r : rooms) {
                if (r.num < m && Math.abs(r.level - l) <= 10 ) {
                    involved = true;
                    r.num++;
                    r.list.offer(new Player(l, nn));
                    break;
                }
            }
            if (!involved) {
                PriorityQueue<Player> temp = new PriorityQueue<>(new Comparator<Player>() {
                    @Override
                    public int compare(Player o1, Player o2) {
                        return o1.name.compareTo(o2.name);
                    }
                });
                temp.offer(new Player(l, nn));
                rooms.add(new Room(l, 1, temp));
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Room r : rooms) {
            if (r.num == m) {
                bw.append("Started!\n");
            }
            else {
                bw.append("Waiting!\n");
            }
            while (!r.list.isEmpty()) {
                Player temp = r.list.poll();
                bw.append(temp.level + " " + temp.name + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
    static class Room {
        public int level;
        public int num;
        public PriorityQueue<Player> list;
        public Room(int level, int num, PriorityQueue<Player> list) {
            this.level = level;
            this.list = list;
            this.num = num;
        }
    }

    static class Player {
        int level;
        String name;
        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
}

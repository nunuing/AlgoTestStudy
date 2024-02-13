import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if (temp.length() >= m) {
                if (map.containsKey(temp)) {
                    int tcnt = map.get(temp);
                    map.replace(temp, tcnt + 1);
                }
                else {
                    map.put(temp, 1);
                }
            }
        }
        br.close();

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for (String now : map.keySet()) {
            pq.offer(new Word(now, map.get(now)));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!pq.isEmpty()) {
            bw.append(pq.poll().str + "\n");
        }
        bw.flush();
        bw.close();
    }
    static class Word implements Comparable<Word>{
        public String str;
        public int length;
        public int cnt;
        public Word(String str, int cnt) {
            this.str = str;
            this.length = str.length();
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt != o.cnt) {
                return o.cnt - this.cnt;
            }
            if (this.length != o.length) {
                return o.length - this.length;
            }
            return this.str.compareTo(o.str);
        }
    }
}

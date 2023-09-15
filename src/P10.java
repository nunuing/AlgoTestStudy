import java.util.Arrays;
import java.util.HashMap;

public class P10 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {180, 5000, 10, 600}, new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
        System.out.println(solution(new int[] {120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}));
        System.out.println(solution(new int[] {1, 461, 1, 10}, new String[]{"00:00 1234 IN"}));
    }
    static public int[] solution(int[] fees, String[] records) {
        int[] answer = new int[records.length];
        HashMap<Integer, Time> hm = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            String[] time = info[0].split(":");

            int cNum = Integer.parseInt(info[1]);
            Time temp = new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
            if (info[2].equals("IN")) {
                hm.put(cNum, temp);
            }
            else if (info[2].equals("OUT")) {
                Time in = hm.remove(cNum);
                answer[cnt++] = calCost(fees, in.minus(temp));
            }
        }
        for (Time t : hm.values()) {
            answer[cnt++] = calCost(fees, t.minus());
        }

        return answer;
    }
    static class Time {
        public int hour;
        public int minute;
        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }
        public int minus(Time t){
            Time result = new Time(0, 0);
            if (t.minute < this.minute) {
                t.hour--;
                t.minute += 60;
                result.minute = t.minute - this.minute;
            }
            result.hour = t.hour - this.hour;

            return result.hour * 60 + result.minute;
        }
        public int minus(){
            Time result = new Time(0, 0);
            Time t = new Time(23, 59);

            if (t.minute < this.minute) {
                t.hour--;
                t.minute += 60;
                result.minute = t.minute - this.minute;
            }
            result.hour = t.hour - this.hour;

            return result.hour * 60 + result.minute;
        }
    }
    static int calCost(int[] fees, int time) {
        int answer = 0;
        if (time <= fees[0]) {
            answer = fees[1];
        }
        else {
            answer += fees[1];
            time -= fees[0];
            while (time - fees[2] >= 0) {
                time -= fees[2];
                answer += fees[3];
            }
        }
        return answer;
    }
}

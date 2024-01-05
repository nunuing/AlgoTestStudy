import java.util.*;

public class P10 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
        System.out.println(solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"}));
        System.out.println(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}));
    }

    static public int[] solution(int[] fees, String[] records) {
        HashMap<String, Car> hm = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            String[] time = info[0].split(":");

            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            if (info[2].equals("IN")) {
                if (!hm.containsKey(info[1])){
                    hm.put(info[1], new Car(info[1], h, m));
                }
                else {
                    Car t = hm.remove(info[1]);
                    hm.put(info[1], new Car(info[1], h, m, t.acc, false));
                }
            } else if (info[2].equals("OUT")) {
                Car in = hm.remove(info[1]);
                hm.put(info[1], new Car(info[1], h, m, in.acc + in.minus(h, m), true));
            }
        }

        List<Car> list = new ArrayList<>();
        for (String str : hm.keySet()) {
            Car c = hm.get(str);
            if (!hm.get(str).isOut) {
                list.add(new Car(c.carNumber, c.hour, c.minute, c.acc + c.minus(23, 59), true));
            }
            else {
                list.add(c);
            }
        }
        Collections.sort(list);
        int[] answer = new int[hm.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = calCost(fees, list.get(i).acc);
        }
        return answer;
    }

    static class Car implements Comparable<Car>{
        String carNumber;
        public int hour;
        public int minute;
        public int acc = 0;
        public boolean isOut = false;

        public Car(String carNumber, int hour, int minute) {
            this.carNumber = carNumber;
            this.hour = hour;
            this.minute = minute;
        }
        public Car(String carNumber, int hour, int minute, int acc, boolean isOut) {
            this.carNumber = carNumber;
            this.hour = hour;
            this.minute = minute;
            this.acc = acc;
            this.isOut = isOut;
        }

        public int minus(int th, int tm) {
            int hour = 0;
            int minute = 0;
            if (tm >= this.minute) {
                minute = tm - this.minute;
            } else if (tm < this.minute) {
                th--;
                tm += 60;
                minute = tm - this.minute;
            }
            hour = th - this.hour;

            return hour * 60 + minute;
        }

        @Override
        public int compareTo(Car o) {
            return this.carNumber.compareTo(o.carNumber);
        }
    }

    static int calCost(int[] fees, int time) {
        int answer = 0;

        if (time <= fees[0]) {
            answer = fees[1];
        } else {
            answer += fees[1];
            time -= fees[0];
            if (time % fees[2] == 0) {
                answer += (time / fees[2]) * fees[3];
            }
            else {
                answer += (time / fees[2] + 1) * fees[3];
            }
        }
        return answer;
    }

}

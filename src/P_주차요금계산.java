import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class P_주차요금계산 {
    static int dTime;
    static int dFee;
    static int duration;
    static int duraFee;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }
    static public int[] solution(int[] fees, String[] records) {

        dTime = fees[0];
        dFee = fees[1];
        duration = fees[2];
        duraFee = fees[3];
        HashMap<String, Time> cars = new HashMap<>(); //주차장
        HashMap<String, Integer> carList = new HashMap<>(); //차 번호 + 시간
        for (String record : records) {
            String[] temp = record.split(" ");
            String time = temp[0];
            String number = temp[1];
            String type = temp[2];

            if (type.equals("IN")) {
                //주자장에 차가 들어갈때
                cars.put(number, new Time(time));
            }
            else {    //주차장에서 차가 나올때
                if (!carList.containsKey(number)) {     //주차 기록이 없는 경우
                    Time outTime = new Time(time);
                    int minute = outTime.minus(cars.get(number));
                    carList.put(number, minute);
                }
                else { // 이미 주차 기록이 있는 경우 -> 시간 합산
                    Time outTime = new Time(time);
                    int minute = outTime.minus(cars.get(number));
                    int newMinute = carList.get(number) + minute;
                    carList.replace(number, newMinute);
                }
                cars.remove(number);
            }
        }

        for (String number : cars.keySet()) {
            Time outTime = new Time("23:59");
            if (!carList.containsKey(number)) {     //주차 기록이 없는 경우
                int minute = outTime.minus(cars.get(number));
                carList.put(number, minute);
            }
            else { // 이미 주차 기록이 있는 경우 -> 시간 합산
                int minute = outTime.minus(cars.get(number));
                int newMinute = carList.get(number) + minute;
                carList.replace(number, newMinute);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> sortedCar = new ArrayList<>(carList.keySet());
        Collections.sort(sortedCar);
        int idx = 0;
        for (String number : sortedCar) {
            answer.add(calFee(carList.get(number)));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    static int calFee(int minute) {
        int result = dFee;
        if (minute <= dTime) {
            return result;
        }
        minute -= dTime;
        int cnt = minute / duration;
        if (minute % duration != 0) {
            cnt++;
        }
        result += (cnt * duraFee);
        return result;
    }
    static class Time {
        public int hour;
        public int minute;
        public Time(String time) {
            String[] temp = time.split(":");
            this.hour = Integer.parseInt(temp[0]);
            this.minute = Integer.parseInt(temp[1]);
        }

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        int minus(Time t) {
            if (t.minute < t.minute) {
                t.hour--;
                t.minute += 60;
            }
            return (this.hour - t.hour) * 60 + (this.minute - t.minute);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if(!input.equals("0")) {
        String[] converter = {"000", "001", "010", "011", "100", "101", "110", "111"};

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            answer.append(converter[input.charAt(i) - '0']);
        }


            while (answer.charAt(0) == '0') {
                answer.deleteCharAt(0);
            }
            System.out.println(answer);
        }
        else System.out.println(0);
    }
}

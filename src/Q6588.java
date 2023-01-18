import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num;
        int max = 0;
        Queue<Integer> integers = new LinkedList<>();
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            integers.add(num);
            max = (max < num) ? num : max;
        }

        boolean[] isPrime = new boolean[max + 1];
        isPrime[0] = true;
        isPrime[1] = true;

        for(int i = 2; i <= max; i++){
            for(int k = i*2; k <= max; k += i){
                isPrime[k] = true;
            }
        }

        while (!integers.isEmpty()){
            boolean possible = false;
            for(int n = 2; n <= integers.peek() / 2; n++){
                if(!isPrime[n] && !isPrime[integers.peek() - n]){
                    System.out.println( integers.peek() + " = " + n + " + " + (integers.peek() - n));
                    possible = true;
                    break;
                }
            }
            if(!possible)
                System.out.println("Goldbach's conjecture is wrong.");
            integers.poll();
        }
    }
}

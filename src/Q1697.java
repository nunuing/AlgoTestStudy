import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        int pos = n;
        queue.offer(pos);
        dist[pos] = 0;

        while (!queue.isEmpty()){
            pos = queue.poll();
            if(pos == k)
                break;

            for (int i = 0; i < 3; i++){
                int temp = pos + 1;
                if (i == 1)
                    temp = pos - 1;
                else if (i == 2)
                    temp = pos * 2;

                if (temp >= 0 && temp <= 100000){
                    if (dist[temp] == -1){
                        dist[temp] = dist[pos] + 1;
                        queue.offer(temp);
                    }
                }
            }
        }
        System.out.println(dist[k]);
    }
}

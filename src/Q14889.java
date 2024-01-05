import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
    static int n;
    static int[][] stats;
    static boolean[] matched;
    static int minDiff;
    static int[] start, link;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        stats = new int[n][n];
        matched = new boolean[n];
        StringTokenizer st;
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            matched[i] = false;
            for(int j = 0; j < n; j++){
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minDiff = 10000;
        start = new int[n/2];
        link = new int[n/2];
        matching(0, 0);
        System.out.println(minDiff);
    }
    static void matching(int cnt, int now){
        if(cnt == n/2){
            int l_idx = 0;
            for(int i = 0; i < n; i++){
                if(!matched[i]){
                    link[l_idx++] = i;
                }
            }

            int t_start = 0;
            int t_link = 0;
            for(int i = 0; i < n/2; i++){
                for(int j = 0; j < n/2; j++){
                    t_start += stats[start[i]][start[j]];
                    t_link += stats[link[i]][link[j]];
                }
            }
            int temp = Math.abs(t_start - t_link);
            minDiff = temp < minDiff ? temp : minDiff;
            return;
        }

        for(int i = now; i < n; i++){
            if(!matched[i]){
                matched[i] = true;
                start[cnt] = i;
                matching(cnt + 1, i + 1);
                matched[i] = false;
            }
        }
    }
}

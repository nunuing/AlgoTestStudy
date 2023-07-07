import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15661 {
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
        start = new int[n];
        link = new int[n];
        matching(0, n, 0);
        System.out.println(minDiff);
    }
    static void matching(int s, int l, int now){
        if(s > n){
            return;
        }
        if(s >= 1){
            int l_idx = 0;
            for(int i = 0; i < n; i++){
                if(!matched[i]){
                    link[l_idx++] = i;
                }
            }

            int t_start = 0;
            int t_link = 0;
            for(int i = 0; i < s; i++){
                for(int j = 0; j < s; j++){
                    t_start += stats[start[i]][start[j]];
                }
            }
            for(int i  = 0; i < l; i++){
                for(int j = 0; j < l; j++){
                    t_link += stats[link[i]][link[j]];
                }
            }

            int temp = Math.abs(t_start - t_link);
            minDiff = temp < minDiff ? temp : minDiff;
        }

        for(int i = now; i < n; i++){
            if(!matched[i]){
                matched[i] = true;
                start[s] = i;
                matching(s + 1, l -1, i + 1);
                matched[i] = false;
            }
        }
    }
}

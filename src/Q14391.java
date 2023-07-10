import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14391 {
    static int n, m, answer;
    static int[][] paper;
    static boolean[][] direction;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        direction = new boolean[n][m];
        for(int i = 0; i < n; i++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                paper[i][j] = temp[j] - '0';
            }
        }

        answer = 0;
        folding(0, 0);
        System.out.println(answer);
    }
    static void folding(int row, int col){
        if(row == n - 1 && col == m){           
            //row == n - 1 && col == m - 1일 경우 마지막 경우를 계산하지 않기 때문에 col == m 까지로 설정해 모든 경우를 다 생각해야함
            int temp = 0, total = 0;
            //가로일 경우 계산
            for(int i = 0; i < n; i++){
                temp  = 0;      //같은 줄에서 마지막 줄까지 가로일 경우를 생각해서 temp를 초기화해주고 total에 더 해준다.
                for(int j = 0; j < m; j++){
                    if(direction[i][j]){
                        temp *= 10;
                        temp += paper[i][j];
                    }
                    else{
                        total += temp;
                        temp = 0;
                    }
                }
                total += temp;
            }
            // 세로일 경우 계산  => 회전해서 생각
            for(int i = 0; i < m; i++){
                temp = 0;
                for(int j = 0; j < n; j++){
                    if(!direction[j][i]){
                        temp *= 10;
                        temp += paper[j][i];
                    }
                    else{
                        total += temp;
                        temp = 0;
                    }
                }
                total += temp;
            }
            answer = total > answer ? total : answer;
            return;
        }
        if(col >= m){
            row++;
            col = 0;
        }
        
        direction[row][col] = true;         //가로
        folding(row, col + 1);
        
        direction[row][col] = false;        //세로
        folding(row, col + 1);
    }
}

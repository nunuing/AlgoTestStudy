import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3190 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n + 1][n + 1];
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			
			board[tx][ty] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		int[][] change = new int[l][2]; 
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			change[i][0] = Integer.parseInt(st.nextToken());
			
			String dir = st.nextToken();
			change[i][1] = dir.equals("D") ? 1 : -1;
			
		}
		
		Queue<Pair> queue = new LinkedList<>();
		Pair head = new Pair(1, 1);
		Pair tail = new Pair(1, 1);
		queue.offer(head);
		board[head.x][head.y] = 2;
		
		int[] mx = {0, 1, 0, -1};
		int[] my = {1, 0, -1, 0};
		int d = 0; 
		
		int sec = 0, cur = 0;
		while (true) {
			sec++;
			int nx = head.x + mx[d];
			int ny = head.y + my[d];
			
			if (nx <= 0 || nx > n || ny <= 0 || ny > n)		//벽과 부딪힘 
				break;
			if (board[nx][ny] == 2)		//자기자신의 몸과 부딪힘 
				break;
			
			if (board[nx][ny] == 0) {		//사과가 아님
				tail = queue.poll();
				board[tail.x][tail.y] = 0;
			}
			
			head = new Pair(nx, ny);
			queue.offer(head);
			board[head.x][head.y] = 2;
			
			if (cur < l && change[cur][0] == sec) {
				d = (d + change[cur][1]) % 4;
				d = d == -1 ? 3 : d;
				cur++;
			}
		}
		System.out.println(sec);
 	}
	static class Pair {
		public int x;
		public int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
}

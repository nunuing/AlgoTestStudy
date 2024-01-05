import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		Pair now = new Pair(x, y);
		
		boolean[][] map = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				char c = st.nextToken().charAt(0);
				map[i][j] = c == '0' ? false : true;
			}
		}
		
		boolean[][] cleaned = new boolean[n][m];
		
		int[] mx = {-1, 0, 1, 0};
		int[] my = {0, 1, 0, -1};
		
		int cnt = 0;
		while (true) {
			if (!cleaned[now.x][now.y]) {
				cnt++;
				cleaned[now.x][now.y] = true;
			}
			
			boolean check = false;
			for (int i = 0; i < mx.length; i++) {
				int tx = now.x + mx[i];
				int ty = now.y + my[i];
				
				if (tx < 0 || tx >= n || ty < 0 || ty >= m)
					continue;
				
				if (!map[tx][ty] && !cleaned[tx][ty]) {
					check = true;
					break;
				}
			}
			
			if (!check) {
				int tx = now.x - mx[d];
				int ty = now.y - my[d];
				
				if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
					break;
				}
				else if (map[tx][ty])
					break;
				else {
					now = new Pair(tx, ty);
				}
			}
			
			else if (check) {
				if (--d < 0)
					d = 3;
				int tx = now.x + mx[d];
				int ty = now.y + my[d];
				
				if (tx < 0 || tx >= n || ty < 0 || ty >= m) 
					continue;
				else if (map[tx][ty])
					continue;
				else if (!cleaned[tx][ty]) {
					now = new Pair(tx, ty);
				}
			}
		}
		System.out.println(cnt);
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

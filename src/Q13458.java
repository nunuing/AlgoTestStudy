import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13458 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		int[] students = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int temp = students[i];
			cnt++;
			if (temp <= b) {
				continue;
			}
			else {
				temp -= b;
				cnt += temp % c != 0 ? (temp / c) + 1 : (temp / c); 
			}
		}
		
		System.out.println(cnt);
	}

}

import java.io.*;
import java.util.*;

public class Q4574 {
    static int n, m;
    static int[] num;        //숫자의 루트노드 저장 배열
    static StringBuilder sb = new StringBuilder();    //결과 StringBuilder

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           //입력값 처리하는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));         //결과값 출력하는 BufferedWriter

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n + 1];                                                               //0 ~ (n + 1) 집합 루트노드 설정

        for (int i = 0; i <= n; i++)
            num[i] = i;

        //명령어 수행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0)    //0, 합집합
                union(a, b);
            else        //1, 교집합
                isCheck(a, b);
        }

        bw.write(sb.toString());        //결과 BufferedWriter 저장
        bw.flush();        //결과 출력
        bw.close();
        br.close();
    }
    //루트 노드의 값 찾기 함수
    static int find(int n) {
        if (n == num[n])
            return n;
        return num[n] = find(num[n]);
    }

    //루트 노드 값이 더 작은 값으로 합치는 함수
    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            if (x > y)
                num[y] = x;
            else
                num[x] = y;
        }
        return;
    }

    //두 집합의 루트노드가 같은지 확인하는 함수
    static void isCheck(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x == y)
            sb.append("YES\n");
        else
            sb.append("NO\n");
        return;
    }
}
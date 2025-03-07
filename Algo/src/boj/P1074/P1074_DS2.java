package boj.P1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 재귀호출
public class P1074_DS2 {
    static int N, r, c, ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        // 풀이
        N = (int) Math.pow(2, N); // 2의 제곱수이므로 계속 반으로 나눌 수 있다.
        
        z( 0, 0 );
        
        System.out.println(ans);
    }
    static void z(int y, int x) { // 시작점 (최초 원점)
        
        // 기저조건
        if( N == 1 ) return;
        
        N /= 2;
        
        // r,c 가 4개의 영역 중 어디에 있는 지 판단 
        if( r < y + N && c < x + N ) { // 상좌
            z(y, x);
        }else if( r < y + N && c >= x + N ) { // 상우
            ans += N * N * 1;
            z(y, x + N); // 원점 우로 이동
        }else if( r >= y + N && c < x + N ) { // 하좌
            ans += N * N * 2;
            z(y + N, x); // 원점 하로 이동
        }else {
            ans += N * N * 3;
            z( y + N, x + N);
        }       
    }
}
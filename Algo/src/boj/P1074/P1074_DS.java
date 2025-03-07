package boj.P1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1074_DS {
	static int N,r,c,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input.split(" ")[0]);
		r = Integer.parseInt(input.split(" ")[1]);
		c = Integer.parseInt(input.split(" ")[1]);
		
		N = (int)Math.pow(2, N);
		
		
		int y = 0; 
		int x = 0;
		
		while(true) {
			if(N == 1)break;
			
			N/=2;
			
			// r,c 가 4개의 영역 중 어디에 있는 지 판단 
            if( r < y + N && c < x + N ) { // 상좌
                ;
            }else if( r < y && c >= x + N ) { // 상우
                ans += N * N * 1;
                x += N; // 원점 우로 이동
            }else if( r >= y + N && c < x + N ) { // 하좌
                ans += N * N * 2;
                y += N; // 원점 하로 이동
            }else {
                ans += N * N * 3;
                y += N; // 원점 하로 이동
                x += N; // 원점 우로 이동
            }
		}
		
		 System.out.println(ans);
	}
}

package boj.p2839_설탕공장_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt;
		
		cnt = N/5;
		N %= 5;		
		System.out.println(cnt);
		while(true) {
			if(N%3 != 0 || N < 3) {
				cnt--;
				N += 5;
			}else {
				cnt += N /3;				
				break;
			}				
			
			if(cnt == 0) {
				System.out.println(-1);
				break;
			}
		}
		
		System.out.println(cnt);
		
		 
	}
}

package boj.p2447_별찍기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//분할 정복
public class P2447 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		int k = 0;
//		while(N > 0) {
//			k++;
//			N /= 3;			
//		}
//		k-=1;
//		
		while(true) {
			if(N == 1) break;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(j == 1 && i == 1) {
						System.out.print(" ");
					}else {
						System.out.print("*");
					}					
				}
				System.out.println();
			}
			
			System.out.println(N);
			N/=3;
			
		}
	}
}

package boj.p1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input.split(" ")[0]);
		int K = Integer.parseInt(input.split(" ")[1]);
		
		int[] lines = new int[N];
		for(int i = 0; i < N; i ++ ) {
			lines[i] = Integer.parseInt(br.readLine());
		}
		
		long sum_lines = 0;
		for(int line : lines) {
			sum_lines+= line;
		}
		
		long answer = sum_lines/K;
		int k = 0; 
		//k가 계속 작울 때는 answer를 줄여서 k를 크게 해주다가.
		while(true) {
			k = 0;
			for(int line: lines) {
				k += line/answer;
			}			
			if(k > K) {
				answer += answer/2;					
			}else if(k < K){
				answer = answer/2;				
			}else {
				//k가 K-1이 될때까지 answer를 ++;
				while(true) {
					k = 0;
					answer++;
					for(int line: lines) {
						k += line/answer;
					}					
					if(k == K-1) {
						break;
					}
				}
				break;
			}			
		}
		
		System.out.println(answer-1);
		
	}
}

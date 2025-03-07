package boj.P1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long N = Integer.parseInt(input.split(" ")[0]);
		int r = Integer.parseInt(input.split(" ")[1]);
		int c = Integer.parseInt(input.split(" ")[2]);
				
		traverse((int)Math.pow(2, N),r,c);
		
		System.out.println(answer);
	}
	static int x = 0;
	static int y = 0;
	static int answer;
	
	static void traverse(int N,int r, int c) {		
		if(N==1) {
			answer++;
			if(x==r && y==c) {
				return;
			}	
			x++;
			answer++;
			if(x==r && y==c) {
				return;
			}	
			x--;
			y++;
			answer++;
			if(x==r && y==c) {
				return;
			}
			x++;
			answer++;
			if(x==r && y==c) {
				return;
			}
						
			answer++;
			return;
		}
		
		traverse(N/2,r,c);
	}
}

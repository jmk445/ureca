package boj.p2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2493 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] towers = new int[N]; 
		for(int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(towers[0]);
		
		
		int[] answer = new int[towers.length];
		int idx = 0;
		for(int i = 1; i < towers.length; i++) {
			//Stack에서 tower보다 처음으로 큰 tower를 찾으면 그 idx를 해당 answer[tower의 인덱스]에 저장
			//Stack에서 못찾으면
						
			int tower = stack.peek();
			System.out.println(tower);
			if(towers[i] < tower) {	
				stack.push(towers[i]);
				answer[i] = idx;				
			}else {				
				int tmp = 0;
				while(true) {
					tmp = stack.pop();					
					if(tmp > towers[i]) {												
						break;
					}
				}	
				stack.push(tmp);
				stack.push(towers[i]);
				idx = i + 1;
//				System.out.println(towers[i]);								
//				System.out.println(idx);
			}								

		}
		
		System.out.println(Arrays.toString(answer));
		
	}
}

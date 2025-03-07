package boj.p1915_가장큰정사각형_dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1915 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		
		for(int j = 0; j < n; j++) {
			char[] line = br.readLine().toCharArray();
			
			for(int i = 0; i < line.length;i ++) {
				map[j][i] = line[i] - '0';
			}			
		}
		
		int[][] record = map;
		
		int max = record[0][0] * record[0][0];
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				int num1 = record[i-1][j-1];
				int num2 = record[i-1][j];
				int num3 = record[i][j-1];
				int min = 0;
				if(num1 < num2) {
					min = num1;
					if(num3< num1) {
						min = num3;
					}
				}else {
					min = num2;
					if(num3 < num2) {
						min = num3;
					}
				}																			
				record[i][j] = map[i][j] + min; 
				if(max < record[i][j]) {
					max = record[i][j];
				}
			}
		}
		
		for(int i = 0 ; i < n; i ++ ) {		
			System.out.println(Arrays.toString(record[i]));
		}
		
		System.out.println(max * max);
		
	}
}

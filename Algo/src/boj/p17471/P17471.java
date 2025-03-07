package boj.p17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17471 {
	static int[] tgt;
	static int[] src;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] popul = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] map = new int[N+1][];
		int connectCnt = 0;
		for(int i = 1; i < N + 1;i ++) {
			st = new StringTokenizer(br.readLine());
			connectCnt = Integer.parseInt(st.nextToken());
			int[] line = new int[connectCnt];
			for(int j = 0; j < connectCnt; j++) {
				line[j] = Integer.parseInt(st.nextToken());
			}
			map[i] = line;
		}
		
		
		for(int i = 0; i < N; i++) {
			//i개 뽑기
			tgt = new int[i];
			src = new int[N];
			for(int j = 0; j < N;j ++ ) {
				src[j] = j+1;
			}
			
			comb(0,0);
			
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {		
			System.out.println(Arrays.toString(tgt));
//			bfs();
			return;
		}
		if(srcIdx == src.length) {			
			return;
		}
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
			
}

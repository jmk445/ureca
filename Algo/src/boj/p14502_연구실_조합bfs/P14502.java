package boj.p14502_연구실_조합bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14502 {
	static Node[] tgt = new Node[3];
	static List<Node> notWall = new ArrayList<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());		
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					notWall.add(new Node(i,j));
				}
			}
		}
		
		comb(0,0);
			
		
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			return;
		}
		
		if(srcIdx == notWall.size()) {
			return;
		}
		
		tgt[tgtIdx] = notWall.get(srcIdx);
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1,tgtIdx);
	}
	
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}

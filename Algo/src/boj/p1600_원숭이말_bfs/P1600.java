package boj.p1600_원숭이말_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1600 {
	static Queue<Node> queue = new ArrayDeque<>();
	static int[][] board;
	static int[] dy_horse = {2,2,1,-1,-2,-2,1,-1};
	static int[] dx_horse = {-1,1,-2,-2,-1,1,2,2};
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,-1,0,1};
	static int W,H;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		for(int j = 0; j < H; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < W; i++) {
				board[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		Node node = new Node(0,0,0);
		visit = new boolean[H][W];
		
		int answer = bfs(node, K);
		
		
		System.out.println(answer);
		
	}
	
	static class Node{
		int y;
		int x;
		int len;
		public Node(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}		
	}
	
	static int bfs(Node node,int K) {
		int k = 0;
		int len = 0;
		queue.offer(node);		
		while(!queue.isEmpty()) {
			Node node1 = queue.poll();
			if(node1.y == W-1 && node1.x == H - 1) {
				return node1.len;
			}
			if(k < K) {
				for(int d = 0; d < 8; d++) {
					int ny = node1.y + dy_horse[d];
					int nx = node1.x + dx_horse[d];
					if(ny < 0 || ny >= H || nx < 0 || nx >= W   ) continue;
					if(visit[ny][nx]) continue;
					for(int i = 0 ; i < 3; i++) {
						
					}
					if(board[ny][nx] == 1) continue;
					
					visit[ny][nx] = true;
					len++; //??
					k++;
					queue.offer(new Node(ny,nx,len));
					System.out.println("===============");
					System.out.println(node1.y + "parent" + node1.x);
					System.out.println(ny+"child" + nx);
					System.out.println(d + "info" + len);
					System.out.println("===============");
				}
			}else {
				for(int d = 0; d < 4; d++) {
					int ny = node1.y + dy[d];
					int nx = node1.y + dy[d];
					if(ny < 0 || ny > H || nx < 0 || nx > W || visit[ny][nx]  ) continue;
					if(board[ny][nx] == 1) continue;

					visit[ny][nx] = true;
					len++; //??
					queue.offer(new Node(ny,nx,len));
				}
			}
		}
		
		return -1;
		
	}
}

package boj.p17070_파이프옮기기_dp완탐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17070 {
	static int[] dy_tail = {0,1,1};
	static int[] dx_tail = {1,0,1};
	static int[] dy_head = {0,1,0};
	static int[] dx_head = {1,1,1};
	
	static int[][] house;
	
	static int N,cnt;
	
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Pipe pipe = new Pipe(new Node(0,0), new Node(0,1), 0); //0 : 가로 1:세로 2: 대각선
		
		bfs(pipe);
		
		System.out.println(cnt);
	}
	
	static class Node{
		int y;
		int x;
		public Node(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static class Pipe {
		Node head;
		Node tail;
		int dir;
		public Pipe(Node head, Node tail, int dir) {
			this.head = head;
			this.tail = tail;
			this.dir = dir;
		}
		
//		void move(int dir) {
//			if(dir == 0) {
//				Node newHeadNode = new Node(this.head +)
//				this.head = new Node(,);
//			}
//		}
	}
	
	static void bfs(Pipe pipe) {
		Queue<Pipe> queue = new ArrayDeque<>();
		
		queue.offer(pipe);
		
		while(!queue.isEmpty()) {
			Pipe curPipe = queue.poll();
			if(curPipe.dir == 0) {
				//가로로 
				if(curPipe.head.x + 1 < N) queue.offer(new Pipe(new Node(curPipe.head.y, curPipe.head.x + 1),new Node(curPipe.tail.y, curPipe.tail.x + 1),0));
				
				//대각선으로
			}else if(curPipe.dir == 1) {
				
			}else {
				
			}
			for(int d = 0; d < 3; d++) {
				
			}
		}
	}
		
 	
 	
 	
 	
}

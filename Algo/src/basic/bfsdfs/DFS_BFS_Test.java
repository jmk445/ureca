package basic.bfsdfs;

import java.util.ArrayDeque;
import java.util.Queue;

//2차원 배열에 상하 좌우 탐색을 통한 dfs, bfs 구현 
public class DFS_BFS_Test {

	static int[][] map = {
            {0,  0,  0,  0,  0,  0,  0}, //dummy 각 열, 행의 0번째는 사용 X
            {0, 11, 12, 13, 14, 15, 16},
            {0, 21, 22, 23, 24, 25, 26},
            {0, 31, 32, 33, 34, 35, 36},
            {0, 41, 42, 43, 44, 45, 46},
            {0, 51, 52, 53, 54, 55, 56},
            {0, 61, 62, 63, 64, 65, 66},
    };
    
    // 상 - 하 - 좌 - 우 순서
    static int[] dy = { -1, 1,  0, 0 };
    static int[] dx = {  0, 0, -1, 1 };
    
    
	public static void main(String[] args) {
		//bfs(3,3); //3,3에서 부터 상하 좌우로 bfs 하는 순서를 쭉 찍어보겠다. 
		
		
		
		//dfs()
	}
	static boolean[][] visit;
	static void dfs(int y, int x) {
		
		visit[y][x] = true;
		System.out.println(map[y][x]);
		//기저 조건 없음
		//why ? : 모든 버텍스를 봐야함. 
		
		for(int d = 0; d < 4; d++) {			
			int ny = y + dy[d];
			int nx = x + dx[d];			
			if(y >= map.length || y < 1 || x >=map.length || x < 1 || visit[ny][nx]) {
				continue;
			}
			dfs(ny, nx);
			
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(y,x));
		visit[y][x] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node);
			
			for(int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if(ny < 1 || nx < 1 || ny >= 7 || nx >= 7 || visit[ny][nx]) continue;
				
				queue.offer(new Node(ny, nx));
				visit[ny][nx] = true;
			}
		}
	}
	static class Node{
		int y, x;
		Node(int y, int x ){
			this.y = y;
			this.x = x;
		}
		
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}
		
		
	}

}

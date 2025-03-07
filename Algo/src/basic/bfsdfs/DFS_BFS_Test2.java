package basic.bfsdfs;

import java.util.ArrayDeque;
import java.util.Queue;

//그래프 자료구조 중 인접 행렬
//제방문 x <= visit
//가중티 x , 유향 -> 자료구조 활용, 방문 순서 집중!! 
public class DFS_BFS_Test2 {
	static boolean[][] matrix;
	static boolean[] visit;
		
	public static void main(String[] args) {
		//정점 1,2,3,4와 연결 간선을 직접 처리
		matrix = new boolean[5][5]; //0은 더미, 정점 4개
		//간선
		//1 -> 2,4
		//2 -> 3,4
		//3 -> 2
		//4 -> 3
		
		matrix[1][2] = true;
		matrix[1][4] = true;
		matrix[2][3] = true;
		matrix[2][4] = true;
		matrix[3][2] = true;
		matrix[4][3] = true;
		
		//visit 초기화
		visit = new boolean[5]; //0: dummy
		
		
//		dfs(1); //시작 정점이 1번이다.
		bfs(1);
		
	}
	
	public static void dfs(int v) {
		//해당 지점에서 할 일 진행
		visit[v] = true;
		System.out.print(v + " -> ");
		
		//dfs()를 이어갈 수 있는 다음 정점 방문
		
//		for(int y = 0; y < matrix.length; y++ ) {
//			for(int x = 0; x < matrix[y].length; x++) {
//				if(matrix[y][x] == true) {
//					dfs(x);
//				}
//			}
//			
//		}
		
		for(int i = 1; i <= 4; i++) {
			if(!matrix[v][i] || visit[i]) continue;
			dfs(i);
		}
		
		
	}
	
	public static void bfs(int sv) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(sv);
		visit[sv] = true;
		
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v + "-> ");
			
			for(int i = 1; i < 4; i++) {
				if(matrix[v][i] != true || visit[i])continue;
				queue.offer(i);
				visit[i] = true;
			}
		}
	}

}

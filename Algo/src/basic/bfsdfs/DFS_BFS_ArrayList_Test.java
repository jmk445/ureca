package basic.bfsdfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//2차원 배열에 상하 좌우 탐색을 통한 dfs, bfs 구현 
public class DFS_BFS_ArrayList_Test {
	static List<List<Integer>> adjList = new ArrayList<>();	
	static boolean[] visit;
    
   
    
	public static void main(String[] args) {
		//정점 1,2,3,4와 연결 간선을 직접 처리
		//정점의 개수 만큼 ArrayList 객첼글 adjList에 추가
		
		for(int i = 0; i < 5; i++) { //dummy를 위한 +1
			adjList.add(new ArrayList<Integer>()); //0번째는 dummy					
		}
		
		adjList.get(1).add(2);
		adjList.get(1).add(4);
		adjList.get(3).add(3);
		adjList.get(2).add(4);
		adjList.get(3).add(1);
		adjList.get(4).add(3);
				
	}
	
	static void dfs(int v) {		
		visit[v] = true;
		System.out.println(v+ " -> ");
		
		List<Integer> list = adjList.get(v);
		
		for(int i : list) {			
			if(visit[i]) {
				continue;
			}
			dfs(i);			
		}
	}
	
	static void bfs( int sv ) {
		// 시작  Node 를 queue 에 넣고 출발
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer( sv );
		visit[sv] = true;
		
		while( ! queue.isEmpty() ) {
			
			int v = queue.poll();
			System.out.print(v + " -> ");
			
			List<Integer> list = adjList.get(v);
			for (Integer i : list) {
				if( visit[i] ) continue; // 갈 수 없거나, 이미 방문한 정점 제외
				queue.offer(i);
				visit[i] = true;
			}			
		}
	}	

}

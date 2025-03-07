package basic.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import basic.graph.Prim.Vertex;

//한 정점에서 부터 그래프의 다른 정점으로 가는 최단 경로(최소 비용)
//정점(vertex) 중심 풀이
//한 정점으로 부터 다른 모든 정점으로 가는 최소 비용을 관리하는 배열 int[] cost;
//	이 배열을 초기 값을 충분히 큰 값으로 설정, 이 후 알고리즘을 진행하면서 시작 정점으로 부터 비용을 갱신 진행
//	알고리즘 처리가 종료되면 cost[] 의 값이 최소 비용
//	시작 정점 0, 5개의 정점이 있다고 하면, cost{0,4,6,2,7} 
// ~~~

//정점들 에서 다른 모든 연결된 정점 중 최소 비용의 정점을 찾는 방법음 pq를 활용한다.
//pq에서 꺼낸 정점으로부터 갈수 있는 다른 정점을 통해 cost배열 이 갱신하고 갱신된 정점으 ㄹ다시 pq에 넣는다. 
public class Dijkstra {

	static int V, start, end;	
	static int[][] matrix; 	// 인접 행렬
//	static boolean[] visit;	// visit <== 비용 비교를 통해서 visit를 처리, 무조건 다시 가는 경우에는 비쌀 수 밖에 없음 
	static PriorityQueue<Vertex> pqueue = new PriorityQueue<>( (v1, v2) -> v1.c - v2.c ); // 비용 기준
	
	static int[] cost; // dijkstra 의 핵심 자료구조 (프림과 유일하게 다른 점, 이 녀석을 계속 갱신, 최소 비용으로)
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		start = 0;
		end = V - 1;
		matrix = new int[V][V]; //0번부터
		cost = new int[V];
		
		for(int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이
		
		Arrays.fill(cost, INF); //충분히 큰 값으로 초기화 
		
		//시작 정점(start) 부터 시작
		cost[start] = 0;
		pqueue.offer(new Vertex(start, 0));
		
		while(!pqueue.isEmpty()) {
			Vertex vertex = pqueue.poll();
			//visit 체크(cost를 이용)gg
			if(cost[vertex.v] < vertex.c) continue; //교재에서 E까지의 inf가 vertex.c
			 
			//시작 정점(start) -> vertex.v로 부터 cost 비용이 갱신될 수 있다.
			//이미 방문 그리고 비용이 더 높기 때문에 고려할 필요 x
			
			for(int i = 0; i < V; i++) {
				if(matrix[vertex.v][i] == 0) continue;
				if(cost[i] > vertex.c + matrix[vertex.v][i] ) {
					cost[i] = vertex.c + matrix[vertex.v][i];
					//이제 기존의 vetex.c 즉 vertex.v까지 가는 비용은 필요 xx
					pqueue.offer(new Vertex(i, cost[i]));
				}
				
			}
			
		}
		
	}
	

	static class Vertex{
		int v, c; // 정점 객체가 생성되는 시점에 PQ 에서 꺼낸 정점으로부터 갈 수 있는 다른 정점과 그 비용
		Vertex(int v, int c){
			this.v = v;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Vertex [v=" + v + ", c=" + c + "]";
		}

	}
}
//인접 리스트랑 인접 행렬은 입력 테케 에 따라서 다르게 

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0
==> 8
4
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
==> 16
7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0
==> 14
 
 */


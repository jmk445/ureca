package basic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UnionFind2 {
	static int v,e;
	static int[] parent; //각 원소(정점 번호) 별 집합 관계를 표현하는 1차원 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		//그래프 정점(1~6) 간 집합 표현
		//#1. 1차원 배열을 생성
		parent = new int[v+1]; //0 : dummy
		
		//#2.1차원 배열을 초기화필요
		// 각 원소별 자기 자신이 대표 원소가 되도록 (모든 정점이 각각 서로소인 집합)
		makeSet();
				
	}
	
	static void makeSet() {
		//지금은 다 0인데, 자기자신의 인덱스에 부모를 넣어주면 된다.
		//하지만 지금일단 모두 대표원소로 만들어준다. 
		for(int i = 1; i<= v; i++) {
			parent[i] = i; //모두가 대표원소
		}
	}
	
//	static int findSet(int x) {
//		if(parent[x] == x) return x; //대표원소이면 x 리턴 ( 내용이 자기 인덱스와 같을 때)
//		return findSet(parent[x]);  //자기가 대표원소가 아니면 재귀적으로 find
//	}
	
	
	//대표원소를 찾아서 path compression까지 한번에 해주게끔 추가
	static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}
		return findSet(parent[x]);
	}	
		
	//전달된 두 원소 x,y에 대해 x가 속한 집합과 y가 속한 집합을 하나의 집합으로 합치기.
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		//px == py이면 이미 같은 집합이라는 뜻
		//그렇지 않은 경우 규칙을 부요할 수 있다. 가령 다음과 같이 작은 값을 부모로 그냥 하기로 한거임.
		if(px < py) parent[py] = px;
		else parent[px] = py;
	}
	
}

//트리 : 노드(Node), 간선(Edge)
//그래프 : 정점(Vertex), 간선(Edge)

/* 
6 4 <= 정점(v) , 간선(e)
1 4 <= 나머지는 합치는 연산 
2 3
2 4
5 6
*/
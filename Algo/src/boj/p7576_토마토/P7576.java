//package boj.p7576_토마토;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//
//public class P7576 {
//	static int answer;
//	static boolean[][] visited;
//	static int day = 0;
//	static int N;
//	static int M;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String info = br.readLine();
//		StringTokenizer st1 = new StringTokenizer(info);
//		M = Integer.parseInt(st1.nextToken());
//		N = Integer.parseInt(st1.nextToken());
//				
//		int[][] pan = new int[N+1][M+1];
//		
//		
//		int sTomatoX = 0;
//		int sTomatoY = 0;
//		visited = new boolean[N+1][M+1];
//		for(int y = 1; y <= N ; y++) {
//			String line = br.readLine();
//			StringTokenizer st2= new StringTokenizer(line);
//			for(int x = 1; x <= M; x++) {				
//				pan[y][x] = Integer.parseInt(st2.nextToken());
//				if(pan[y][x] == 1) {					
//					sTomatoY = y;
//					sTomatoX = x;					
//				}
//			}			
//		}		
//		
//		bfs(sTomatoY, sTomatoX);
//		
//		System.out.println(day);
//	}
//	
//	static int[] dy = { -1, 1,  0, 0 };
//    static int[] dx = {  0, 0, -1, 1 };
//    
//	static void bfs(int y, int x) {		
//
//		
//		
//		Node sTomato = new Node(0,0);
//		Queue<Node> queue = new ArrayDeque<>();
//		queue.offer(new Node(y,x));
//		visited[y][x] = true;
//		
//		
//		while(!queue.isEmpty()) {
//			day++;
//			Node node = queue.poll();
//			System.out.println(node);
//			
//			for(int d = 0; d < 4; d++) {
//				int ny = node.y + dy[d];
//				int nx = node.x + dx[d];
//				System.out.println(visited[ny][nx]);
//				if(ny < 1 || nx < 1 || ny >= N || nx >= M || visited[ny][nx]) continue;
//				
//				queue.offer(new Node(ny, nx));
//				visited[ny][nx] = true;
//			}
//		}
//	}
//	
//}
//
//class Node{
//	int y;
//	int x;
//	
//	Node(int y, int x){		
//		this.y = y;
//		this.x = x;
//	}
//
//	@Override
//	public String toString() {
//		return "Node [y=" + y + ", x=" + x + "]";
//	}
//	
//	
//}


package boj.p7576_토마토;

import java.io.*;
import java.util.*;

public class P7576 {
    static int[][] pan;
    static boolean[][] visited;
    static int day = 0;
    static int N, M;
    static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());

        pan = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int y = 1; y <= N; y++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int x = 1; x <= M; x++) {
                pan[y][x] = Integer.parseInt(st2.nextToken());
                if (pan[y][x] == 1) { // 익은 토마토가 있는 위치를 큐에 추가
                    queue.offer(new Node(y, x));
                    visited[y][x] = true;
                }
            }
        }

        bfs(); // BFS 실행

        // 모든 토마토가 익었는지 확인
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (pan[y][x] == 0) { // 익지 않은 토마토가 남아 있으면 -1 출력
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day); // 정답 출력
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 날짜에서 익을 수 있는 모든 토마토 처리
            boolean ripened = false;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ny = node.y + dy[d];
                    int nx = node.x + dx[d];

                    // 배열 범위 검사
                    if (ny < 1 || nx < 1 || ny > N || nx > M) continue;
                    // 방문했거나, 빈 공간(-1) 이거나, 이미 익은 토마토(1)면 건너뜀
                    if (visited[ny][nx] || pan[ny][nx] != 0) continue;

                    pan[ny][nx] = 1; // 익은 상태로 변경
                    visited[ny][nx] = true;
                    queue.offer(new Node(ny, nx));
                    ripened = true; // 하루 증가 여부 체크
                }
            }

            if (ripened) day++; // 하루 증가
        }
    }
}

class Node {
    int y, x;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}


package boj.p16236_아기상어_시뮬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16236 {
	
	static int N;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int initY = 0;
        int initX = 0;
        
        for(int j = 0; j < N; j++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());        	
        	for(int i = 0; i < N; i++) {
        		map[j][i] = Integer.parseInt(st1.nextToken());       
        		if(map[j][i] == 9) {
        			initY = j; 
        			initX = i;
        		}
        	}
        }
        
        boolean none = false;
        int sec = 0; 
        
        while(true) {      
        	int minDist = 0;
        	//이번 턴에 먹을 물고기 좌표
        	int victimX = 0; //오류
        	int victimY = 0; //오류
        	for(int j = 0; j < N; j++) {
            	for(int i = 0; i < N; i++ ) {
            		//끝에 도달하였을 경우(중간에 막히지 않고)
            		if(j == N-1 && i == N-1) {
            			none = true;
            		}
            		//오류 : 먹이를 찾았을 경우 이중 for문 탈출해야 함.
            		int dist = getDistance(initY,j, initX, i);
            		if(minDist > dist){ 
            			victimY = j;
            			victimX = i;
            		}
            		Math.min(minDist, dist);            		
            	}
            	if(none) break;
            }        	
        	if (none) break;
        	sec++;
        }
        
        System.out.println(sec);
        	
        
	}
	
	static int getDistance(int y, int y2, int x, int x2 ) {
		return Math.abs(x-x2) + Math.abs(y-y2);
	}
	
	
}

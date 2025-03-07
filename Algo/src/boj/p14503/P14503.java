package boj.p14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class P14503 {
	static int N,M;
	static int[] dy = { 0, 1,0,-1};
	static int[] dx = { -1, 0,1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 (n, m)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 두 번째 줄 입력 (x, y, dir)
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        // 지도 배열 입력
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Robot robot = new Robot(x,y,dir);
        int clean = map[x][y];
        while(true) {        	
        	if(clean == 0) {
        		map[x][y] = 1;
        	}
        	for(int d = 0; d < 4;d++ ) {
        		int ny = y + dy[d];
        		int nx = x + dx[d];
        		if(map[ny][nx] != 1) {
        			while(true) {
        				for(int d1 = 0; d1 < 4; d1++) {
        					d = (d+3)%3;
            				ny = y + dy[d];
                    		nx = x + dx[d];
            				if(map[ny][nx] != 1) {
            					x = nx;
            					y = ny;
            					break;
            				}else {
            					break;
            				}
        				}
        				
        				break;
        			}
        			break;
        		}
        		if(d == 3) {
        			
        		}
        		
        	}
        	
        	
        	
        }
	}
	
	static class Robot{
		int r;
		int c;
		int d;
		public Robot(int r,int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}

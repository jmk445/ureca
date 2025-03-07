package boj.p1987_알파벳_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1987 {
	static int R,C;
	static int cnt,maxCnt;
	
	static char[][] map;
	
	static int[] dy = {-1, 1, 0, 0}; //하 상 좌 우
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][];
        
        for(int j = 0; j < R; j++) {
        	map[j] = br.readLine().toCharArray();
        }
        
        dfs(0,0);
                
	}
	static ArrayList<Character> record = new ArrayList<>();
	
	static void dfs(int y, int x) {

		int wallCnt = 0;				
		cnt++;
		
		for(int d = 0; d < 4; d++ ) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			char value = 'a';
			//밖에 나가지 않으면
			if(!(ny > C-1 || ny < 0 || nx > R-1 || nx < 0)) {
				value = map[ny][nx];
			}
			
			if(!record.contains(value)) {
				record.add(value);
				dfs(ny,nx);
			}else {
				wallCnt++;
				continue;
			}						
		}
		
		//양옆에 쌓인 벽이 4개이므로 이제 못감
		if(wallCnt == 4) {
			if(cnt > maxCnt) {
				maxCnt = cnt;
			}
			return;
		}
		
		
	}
}

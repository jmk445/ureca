package boj.p1987_알파벳_백트래킹;

import java.io.BufferedReader;
import java.lang.Math;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//캡처해둠
public class P1987_SB {
	static int R =0 ,C = 0;
	static int cnt,maxCnt;
	
	static char[][] board;
	
	static int[] dy = {-1, 1, 0, 0}; //하 상 좌 우
	static int[] dx = {0, 0, -1, 1};
	static int MX;
	static boolean[] visit = new boolean[26];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        board = new char[R][];
        
        for(int j = 0; j < R; j++) {
        	board[j] = br.readLine().toCharArray();
        }
        visit[board[0][0] - 'A'] = true;
        
        dfs(0,0,1);
        
        System.out.println(MX);
                
	}
//	static ArrayList<Character> record = new ArrayList<>();
//	static boolean[] alphabets = new boolean[26];
	static void dfs(int y, int x, int len) {
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
						
			//음 아니 나는 무슨 생각으로 ny, nx로 안하고 그냥 y,x로 했지?
//			if( y > R-1 || y < 0 || x > C-1 || x < 0) {
//				continue;
//			}
			if( ny > R-1 || ny < 0 || nx > C-1 || nx < 0) {
				continue;
			}
			
			
			//나는 visit과 alphabets를 따로 생각했음. 근데 sb님은 같은 걸로 생각
			if(visit[board[ny][nx] - 'A']) continue;
			
//			if( alphabets[map[y+dy[d]][x+dx[d]]-'0']) {
//				continue;								
//			}
			
//			alphabets[map[y+dy[d]][x+dx[d]]] = true;
			
			visit[board[ny][nx] - 'A'] = true;
			dfs(ny,nx,len+1);
			visit[board[ny][nx] - 'A'] = false;
		}
		
		MX = Math.max(MX, len);
		
	}
}

package basic.delta;

import java.util.Arrays;

//갈 수 있을 때까지 가게끔
public class DelatTest2 {
	static char[][] map = new char[5][5];
	public static void main(String[] args) {
		char ch = 'A';
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = ch++;
            }
        }
        // 출력
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
         
        int y = 2;
        int x = 2;
        
        System.out.println(map[y][x]);
        
        print4x(2,2);
	}
	

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	//갈 수 있을 때까지 4방으로 끝까지 가는 메소드 
	static void print4x(int y, int x ) {
		for (int d = 0; d < 4; d++) {
			
			int ny = y;
			int nx = x;
			
			while(true) {				
				ny = ny + dy[d];
				nx = nx + dx[d];
				//새로운 좌표 계산을 하면 레인지 체크는 필수적.
				if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) 	break;
				
				System.out.println(map[ny][nx]);
			}
			
								
		}
	}	

	
	
}

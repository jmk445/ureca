package basic.delta;

import java.util.Arrays;
//특정 위치에서 4방 탐색을 진행하는 경우, if-else, if - else if 이런ㅅ믹으로 가면 코드의 길이가 길어지고 가독성이 떨어지고, 나누어서 생각해야하고, 실수하기 쉽다. 
public class DelatTest1 {
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
        
        
        //4방 탐색 - 상 - 하 - 좌 - 우
        //밑으로 내려가는 것은 y 또는 row 로 표현, 옆으로 가는 것을 x 또는 col 로 할것이다. 
        int y = 2;
        int x = 2;
        
        System.out.println(map[y][x]);
        
//        print4x(y, x);
        
        print4x(0,0);
	}
	
	//delta 는 이동방향에 대해서 y의 변화량, x의 변화량을 미리 배열에 저장해두고, 이를 활용해서 새로운 이동좌표(상, 하 , 좌 , 우) 좌표를 구하는 방식
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static void print4x(int y, int x ) {
		for (int d = 0; d < 4; d++) {
			//y,x에서 현재 d 방향으로 이동한 새로운 좌표 계산
			int ny =y+dy[d];
			int nx =x+dx[d];
						
			//새로운 좌표 ny, nx는 배열의 범위를 벗어날 수 있다. 이에 대한 장치 필요
			
			if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) 	continue;
			System.out.println(map[ny][nx]);									
		}
	}	
	
	//문제: 상황좌우로 이동할 수 있다 -> 순서를 상하좌우로 지킬 필요 x
	//문제: 맨 위부터 탐색 시계 방향으로 -> 상 우 하 좌  (-1,0) (1,0) (0,-1) (0,1)
	//문제: 대각선으로 -> (-1, -1) (-1,1) (1,-1) (1,1) 
	//문제: 퀸의 움직임 -> (-2 , -1) ...등등
	//문제: 갈 수 있을 때까지 가는것 (지뢰를 만나기 전까지라거나..)
	
	
	
}

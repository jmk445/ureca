package basic.star;

public class Star1 {
	public static void main(String[] args) {
//		for(int i = 5; i >= 0 ; i--) {
//			for(int j = 0; j < 5- i; j++) {
//				System.out.print(" ");
//			}
//			for(int j = 0; j < i; j++) {
//				System.out.print("*");
//			}			
//			System.out.println("");
//		}
		
		//강사님 코드
		for (int i = 0; i < 5; i++) { // 행
			for (int j = 0; j < 5; j++) { // 열
				
				if( j < i ) { // 왼쪽 아래 공간 
					System.out.print(" ");
				}else { // j == i 줄 포함 오른쪽 위 공간
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}

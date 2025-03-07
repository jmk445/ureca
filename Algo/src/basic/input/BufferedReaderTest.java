package basic.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
	public static void main(String[] args) throws IOException {
		//입력을 받는데 buffer를 이용해서 성능이 빨라지는 것을 테스트 해보았다. 
		//BufferedReader(InputStreamReader());
		//처리 코드은 SCanner에 비해 다소 복잡하지만, 매우 빠른 성능을 보임.
		
		//1 2 3 4 5
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String str = br.readLine();
//			System.out.println(str);
//			
//			int[] input = new int[5];
//			
//			//기본 : str, 하고 " "  , ","등등으로 바꿔도 됨.
//			StringTokenizer st = new StringTokenizer(str);
//			
//			for (int i = 0; i < input.length; i++) {
//				input[i] = Integer.parseInt(st.nextToken());
//			}
//			System.out.println(Arrays.toString(input));
//		}
		//1 A 3 B 5
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String str = br.readLine();
//			System.out.println(str);
//			
//			char[] input = new char[5];
//			
//			//기본 : str, 하고 " "  , ","등등으로 바꿔도 됨.
//			StringTokenizer st = new StringTokenizer(str);
//			
//			for (int i = 0; i < input.length; i++) {
//				input[i] = st.nextToken().charAt(0);
//			}
//			System.out.println(Arrays.toString(input));
//		}
		
		//ABCDE 공백으로 나누어져 있는 애가 아니니까, 토크나이저가 필요가 없다.
//		{ 
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String str = br.readLine();
//			System.out.println(str);
//			
//			char[] input = str.toCharArray();			
//			System.out.println(Arrays.toString(input));
//		}
		

/*
5
ABCDE
 */
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			int N = Integer.parseInt(br.readLine());
//			char[] input = br.readLine().toCharArray();
//			
//			System.out.println(N);
//			System.out.println(Arrays.toString(input));
//		}	
		
/*		
5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
*/
		// 첫 라인에서 읽은 N 만큼 가로 세로가 N 인 2차원 배열
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			int N = Integer.parseInt(br.readLine());
//
//			int[][] input = new int[N][N];
//			
//			for (int i = 0; i < N; i++) {
//				String str = br.readLine();
//				StringTokenizer st = new StringTokenizer(str);
//				for (int j = 0; j < N; j++) {
//					input[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			System.out.println(N);
//			
//			// 1 개씩 확인
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(input[i][j] + " ");
//				}
//				System.out.println();
//			}	
//			
//			// 라인 단위로 확인
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(input[i]));
//			}				
////			
//		}	

		/*
		 5
		 1 2 3 4 5
		 */
		//buffered reader 입장에서는 무조건 그냥 한 줄씩 받아온다고 생각하면 된다.
//		{
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			int N = Integer.parseInt(br.readLine());
//			int[] input = new int[N];
//			
//			String str = br.readLine();
//			StringTokenizer st = new StringTokenizer(str);			
//			for (int i = 0; i < N; i++) {
//				input[i] = Integer.parseInt(st.nextToken());
//			}			
//			System.out.println(Arrays.toString(input));
//		}
		/*
		 3 5
  		 1 2 3 4 5
		 6 7 8 9 0
		 1 2 3 4 5
		 */
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st1.nextToken());
			int col = Integer.parseInt(st1.nextToken());
			int[][] input = new int[row][col];
						
			for(int i = 0; i < row; i++) {
				String str = br.readLine();
				StringTokenizer st2 = new StringTokenizer(str);
				for(int j = 0; j < col; j++) {
					input[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			for(int i = 0; i < row; i++) {
				System.out.println(Arrays.toString(input[i]));
			}
		}
		
		//출력에 대한 자료구조 
		//보통 입력자료 >>> 출력자료
		// 그래서, 출력 자료구조가 간단한 정수 정도라면 별도의 자료구조가 필요 x 
		// 그러나, 출력이 문자열이고 크기가 크다. + 계속 증가한다. 
		// -BufferedWriter라는게 있다. 그러나 이것은 코드가 길어서 너무 귀찮다. 
		// - StringBuilder 는 코드가 짧다. 이것을 쓰도록 append 등등 이용
		
	}
	
}

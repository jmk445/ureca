package basic.input;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
//		{
//			Scanner sc = new Scanner(System.in);
//			int[] input = new int[5];
//			
//			for(int i = 0; i < 5; i++) {
//				input[i] = sc.nextInt();
//			}
//			System.out.println(Arrays.toString(input));
//		}
		//1 A 2 B C
//		{
//			Scanner sc = new Scanner(System.in);
//			char[] input = new char[5];
//			//next는 떨어져있는 문자열을 입력받고 싶을 때 
//			for(int i = 0; i < 5; i++) {
//				input[i] = sc.next().charAt(0);
//			}
//			System.out.println(Arrays.toString(input));			
//		}	
		//ABCDE <- 연속된 문자
//		{
//			Scanner sc = new Scanner(System.in);
////			char[] input = new char[5]; //#2. 그래서 new char[5] 에서도 빈 array를 만들어 놓으면 그것이 garbage가 된다.
//			char[] input;
//			
//			//한줄 전체를 읽는다.
//			
//			input = sc.nextLine().toCharArray(); // #1. tocharArray하면 힙에 새로운 배열을 생성해서 input에게 그 주소를 다시 return 한다. 
//			System.out.println(Arrays.toString(input));
//		}	
		/*
		 5
		 1 2 3 4 5
		 */
//		{
//			Scanner sc = new Scanner(System.in);
//			int N = sc.nextInt();
//			int[] input = new int[N];
//			
//			for(int i = 0; i < 5; i++) {
//				input[i] = sc.nextInt();
//			}
//			System.out.println(N);
//			System.out.println(Arrays.toString(input));
//		}
		/*
		 5
		 ABCDE
		 */
		//#1. 이렇게 하면 에러나는 이유 : next(), nextInt()는 개행문자를 포함하지 않고, nextLine()은 개행 문자를 만나면 읽는 처리는 종료 하기 때문이다. 
		{
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();			
			
			sc.nextLine(); //#2. 그래서 이렇게 개행문자를 처리해주는 nextLine이 필요함. 
			
			char[] input = sc.nextLine().toCharArray();
			
			System.out.println(N);
			System.out.println(Arrays.toString(input));
		}
		
		
	}
}

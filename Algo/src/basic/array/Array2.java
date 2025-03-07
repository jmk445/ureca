package basic.array;

import java.util.Scanner;

public class Array2 {
	public static void main(String[] args) {
		char[] input = {'A', 'B', 'C', 'D', 'E', 'F','G'};
		int len = input.length;
		
		//전체 길이의 2배 순회 출력
		{
//			for (int i = 0; i < len * 2; i++) { //이렇게 되면 어차피 나누기 로 인덱스가 정해지기 때문에 더 큰 수를 써도 된다. 
//				System.out.print(input[i % len]+ " ");
//			}
//			System.out.println();
		}
		
		//a부터 시작해서 특정 수(total)만큼 출력 
		{
			int total = 20;
			for (int i = 0; i < total; i++) { //이렇게 되면 어차피 나누기 로 인덱스가 정해지기 때문에 더 큰 수를 써도 된다. 
				System.out.print(input[i % len]+ " ");
			}
			System.out.println();
		}
	}
}

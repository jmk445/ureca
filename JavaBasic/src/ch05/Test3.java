package ch05;

import java.util.Arrays;

public class Test3 {
	
	public static void main(String[] args) {
		{
			int [] intArray = new int[5]; //길이가 5인 int 배열 객체가 heap에 생성 , 각각의 값은 int의 기본값이 0 초기화
			int [] intArray2 = {1,2,3,4,5};
			int a = 10; int b = 20;
			int[] intArray3 = {a,b,3,4,5};
		}
		{
			int[] intArray = {1,2,3,4};
			
			for(int i : intArray) {
				System.out.println(i);
				i++;
			}
			
			System.out.println(Arrays.toString(intArray));
		}
		
	}

}

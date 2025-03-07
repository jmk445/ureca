package basic.array;

import java.util.HashMap;

public class Array1 {
	public static void main(String[] args) {
		//#1. 주어진 배열의 원소들 중 제시된 규칙과 다른 항목이 몇 건?
		{
//			int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
//			int wrongCnt = 0;
//			for(int i = 2; i < intArray.length - 2 ; i+=3) {
//				if(intArray[i] != intArray[i-2] * intArray[i-1]) {
//					wrongCnt++;
//				}
//			}
//			System.out.println(wrongCnt);
		}
		//#2. 양 끝에서 출발해서 안쪽으로 
		{
//			char[] charArray = "XYZEBFFGQOVVPWGFFCEAYX".toCharArray();
//			int wrongCnt = 0;
//			
//			for(int i = 0; i < charArray.length / 2; i++) {
//				if(charArray[i] != charArray[charArray.length - i -1]) {
//					wrongCnt ++;
//				}
//			}
//			System.out.println(wrongCnt);
//			
//			//강사님 풀이 
//			int center = charArray.length/2;
//			for(int l = 0, r = charArray.length -1 ; l < center ; l++, r++) {
//				if(charArray[l] != charArray[r]) {
//					wrongCnt++;
//				}
//			}
//			System.out.println(wrongCnt);
		}
		{
			//#3.문자열에 포함된 알파벳의 빈도수 출력, 0인 항목도 출력
			//모든 알파벳 소문자가 몇번 나타났는디 
//			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
//			char[] dic = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//			HashMap<Character, Integer > map = new HashMap<Character, Integer>();
//			for(int i = 0 ; i < dic.length; i++) {
//				for(int j = 0; j < str.length(); j++) {
//					if(str.charAt(j) == dic[i]) {
//						
//					}
//				}
//			}
//			
//			
			String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
			int[] alphaCnt = new int[26]; //해당 알파벳 - 'a'
			
			int strLen = str.length();
			for(int i = 0; i < strLen; i++) {
				alphaCnt[str.charAt(i) - 'a']++;
			}
			
			for(int i = 0; i < 26; i++) {
				System.out.println((char)(i + 'a') + " : " + alphaCnt[i]);
			}

		}
		
		
	}

}




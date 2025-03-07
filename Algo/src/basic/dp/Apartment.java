package basic.dp;

//public class Apartment {
//	public static void main(String[] args) {
//		System.out.println(apart(8));
//	}
//	
//	//점화식
//	//f1 = 1, f2 = 3, f3 =  5 f4 = 8
//	
//	static int[] memoi = new int[9];
//	static int apart(int n) {
//		memoi[1] = 2;
//		memoi[2] = 3;
//		
//		for(int i = 3; i <= 8; i++) {
//			return memoi[i] = memoi[i-1] + memoi[i-2];
//		}
//	}
//}



import java.util.Arrays;

// 이전 단계보다 더 늘어난 수는 이전 단계의 노란색의 수와 같다.
//   노란색은 노란색, 파란색 2가지로 늘어난다.
// 이전 단계의 노란색 수는 하나 더 이전 단계의 수와 같다. ( 그 수 전체에 노란색을 사용할 수 있다. )
public class Apartment {

	static int memoi[] = new int[9];
	
	public static void main(String[] args) {
		memoi[1] = 2;
		memoi[2] = 3;
		
		for (int i = 3; i <= 8; i++) {
			memoi[i] = memoi[i-1] + memoi[i-2];
		}
		
		System.out.println(memoi[8]);
		System.out.println(Arrays.toString(memoi));
	}

}
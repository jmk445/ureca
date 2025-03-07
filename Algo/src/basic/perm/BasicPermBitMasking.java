package basic.perm;

import java.util.Arrays;

public class BasicPermBitMasking {
	static int[] src = {1, 2, 3,4,5};
	static int[] tgt = new int[3]; 
	
	
	//사용을 안해보자
//	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		perm(0, 0); //두번째 파라미터로 bitmask 전달 0000 0000			
	}
	
	//mask는 뭐냐, 이전단계까지의 선택 비선택이 표현돼있음.
	static void perm(int tgtIdx, int mask) { //31개 bit를 mask로 표현할 수 있다. (int)  
		//기저 조건
		if(tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			return ;
		}
			
		for (int i = 0; i < src.length; i++) {
			if((mask & 1 << i) != 0  ) { //선택되었다는 이야기. i = 3일때, 0000 0001->0000 1000
				//0000 1000 : 1<<i 
				//0000 1100 : mask (case 1)
				//----------------
				//0000 1000 : 0이 아니라는 이야기는 i번째 자리가 1이라는 이야기. => 해당 자리는 선택되었다는 이야기 (3번째) 
				//만약 0이라는 이야기는 i번째 자리가 0이라는 이야기. 
				continue;
			}
			tgt[tgtIdx] = src[i];
			
//			select[i] = true;
			perm(tgtIdx + 1, mask | 1 << i); //다른 자리를 위한 재귀호출 , mask에 i번째가 무조건 1인 결과물을 보내주는 것
			//원복 x : 전역변수가 아닌 파라미터 복사 전달
		}
		
	}
}


//BitMask 연산


//&연산 : 선택 여부 비교
//0000 1010(두번째, 네번째 사용 중 즉, index 중 1, 3 선택된 상태)
//i = 2 : 1 << i

//  0000 1010
//& 0000 0100
//----------------
// 결과적으로 나머지 다 0이고 3번째만 1인 녀석과 &를 해버리기 때문에, Mask의 3번째 값에 따라 결정된다.


// | 연산 : mask에 선택처리
// i자리만 1이고 나머지 다 0인 애랑 | 연산을 해버리니까 mask의 나머지 자리는 그대로 내려오고, i 자리는 무조건 1로 내려오게 된다.
//  0000 1010
//| 0000 0100
//----------------




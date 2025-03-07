package basic.comb;

import java.util.Arrays;

public class BasicComb {
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3];
	
	//이전에 사용된 수를 고려하지 않기 때문에, (그냥 맨앞에서 부터 가면서 선택/비선택만 고르면됨) 결과적으로 select배열은 필요 x
	public static void main(String[] args) {
		comb(0,0);
		System.out.println(answer);
	}
	static int answer = 0;
	//조합
	//src의 srcIdx 자리의 수를 tgtIdx 자리에 선택? 비선택? 
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건 
		if(tgtIdx == tgt.length ) {
			System.out.println(Arrays.toString(tgt));
			answer++;
			return;
		}
		
		if(srcIdx == src.length) {
			answer++;
			return;
		}
		
		tgt[tgtIdx] = src[srcIdx]; //선택
		comb(srcIdx+1, tgtIdx +1); // 위 선택을 받아 들이고 다음 자리로 재귀 호출
		comb(srcIdx+1, tgtIdx); //위 선택을 받아 들이지 않고, srcIdx만 증가 효과(이전 선택을 srcIdx 다음 수로 덮어쓰는 경우)
		
	}
}

package basic.perm;

import java.util.Arrays;

public class BasicPerm {
	static int[] src = {1, 2, 3,4,5};
	static int[] tgt = new int[3]; //3개를 뽑겠다. <= 현재 자리를 채우기 위해 src 전체를 고려하되, 현재 자리 이전 자리에 사용된 수 제외
	//'현재 자리 이전 자리에 사용된 수' 
	//나는 여기서 사용된 수들의 배열을 생성해서, 나중에 또 이 배열을 순회하는 비효율적인 코드를 짬. 
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		perm(0); //시작 : tgt의 맨 앞자리 부터 시작			
	}
	
	static void perm(int tgtIdx) { 
		//기저 조건
		if(tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			return ;
		}
		
		//현재 파라미터로 넘어온 tgtIdx 자리에 src로 부터 채울 수를 선택, 고려
		//src 전체를 대상으로 하되, select 배열에 사용중인 것은 제외
		
		for (int i = 0; i < src.length; i++) {
			if(select[i]) {				
				continue;
			}
			tgt[tgtIdx] = src[i];
			
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false; //select는 전역 변수이기 때문에 원복해야함.
		}
		
	}
}

package basic.subset;

//전체 부분집합을 재귀호출의 과정에서 완성하지 않고, bit 연산을 통해 한꺼번에 전체 부분집합을 만든 뒤에 반복문으로 처리
//재귀호출으로 완성한뒤 출력 완성한뒤 출력이 아니라 , 다 만들고 한꺼번에 출력하겠다.
public class BasicSubsetBinaryCounting {
	static int[] src = {1,2,3,4,5};
	//공집합 : 00000 ~ > 전체 선택 : 11111 까지 만드는 모든 수가 바로 부분 집합 1개 의미
	static int subsetCnt = 1 << src.length; //2의 5제곱을 하면 전체 부분집합의 개수가 된다. 
	public static void main(String[] args) {
		System.out.println(subsetCnt);
		
		//i의 범위 : 00000->11111
		//i의 범위는 0~31까지의 정수가 되는데, 이 각각의 i가 바로 모든 부분집합의 BitMasking역할을 한다. 
		//즉, 0이면 공집합 1이면 맨앞에 하나가 선택된것 이런식으로 생각할 수 있다는 것
		for(int i = 0; i < subsetCnt; i++) {
			
			for(int j = 0; j < src.length; j++) {
				if((i & 1 << j)!=0) {
					System.out.print(src[j]);
				}
			}
			System.out.println("[" + Integer.toBinaryString(i)+"]\n");
			
		}
	}
}

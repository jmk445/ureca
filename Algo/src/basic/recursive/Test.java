package basic.recursive;

public class Test {
	public static void main(String[] args) {
//		m1();
//		m1_param(0);
//		m2();
		m3();
	}
	
	////변수
	static int m1_i = 0;
	static void m1() {
		//#1. local 변수 <- 재귀 호출마다 스택에 초기화가 된다. 
//		int i = 0;
//		//i를 ++해도 실제로 찍히는 것은 0임을 알 수 있다.
//		System.out.println("m1() " + i++);
		
		//#2. static 변수 <- 재귀 호출마다 공유가 된다. 
		System.out.println("m1() "+ m1_i++);
					
		m1();
	}
	
	static void m1_param(int i) {
		//#3. 파라미터 변수 <- 재귀호출마다 새로운 스택공간에 만들어지고 이전 호출에서 전달된 값을 복사
		System.out.println("m1_param() " + i++);
		m1_param(i);
	}
	
	
	//#4. 자 그냥 재귀를 호출하니까 stack overflow가 일어난다. 그래서 '기저 조건'을 만들어줌
	static int m2_cnt = 5;
	//#5. 자 m2를 해보니까, 5번이 아니라 6번이 나옴 -> 기저조건을 맨위로 해야함.
	static void m2() {
		
		System.out.println("앞 m2() " + m2_cnt);
		//기저조건
		if(m2_cnt > 0) {
			m2_cnt--;
			m2();
		}
		System.out.println("뒤 m2()");
	}
	
		static int m3_cnt = 5;
	
		static void m3() {
			//기저조건
			if(m3_cnt == 0) return;
			System.out.println("앞 m3() " + m3_cnt);
			
			m3_cnt--;
			m3();
			m3_cnt++; //#6. 일단 뒤 m3는 마지막에 몰아서 되는 이유를 이해해야함, 그러고나서, 이게 없으면 0으로 감소한 후 계속 0으로 유지된다. 따라서 원복이 필요하다.
			System.out.println("뒤 m3() " + m3_cnt);
		}
		
		
		
		static void m4(int m4_cnt) {
			//기저조건
			if(m4_cnt == 0) return;
			System.out.println("앞 m4() " + m4_cnt);
			
//			m4_cnt--;
//			m4(m4_cnt);
//			m4_cnt++; 
			
			
			m4(m4_cnt - 1);	//#7. 호출 시 전달받은 m4_cnt는 변화 x
			//#8. but
			
//			m4(m4_cnt --); //-> 5가 전달되기 때문에 스택오버플로우
			
			//but
//			m4(--m4_cnt); //호출 시 전달받은 cnt가 1 감소됨. ->원복 필요
//			m4_cnt++; //이런 방식은 지양
			
			System.out.println("뒤 m4() " + m4_cnt);
		}
}

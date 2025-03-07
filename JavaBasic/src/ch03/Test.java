package ch03;

public class Test {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		
		if(++x == 11 && y++ == 10) {
			System.out.println("A");
		}else {
			System.out.println("B");
		}
		
		System.out.println(x);
		System.out.println(y);
		
		//short circuit
		
		if(++x == 12 || y++ == 11) {
			System.out.println("E");
		}else {
			System.out.println("F");			
		}
		
		//x는 먼저 비교 되어 true로 판명(x는 증가)
		//y는 앞의 x비교식에서 true로 이미 판명 되어 전체 OR연산이 true로 판명되어서 y++ == 12 비교식은 수행 x
		
		//but //가 아니라 / 를 사용할 경우에는 뒤에도 계속 판단을 한다. 즉 shortcircuit이 일어나지 않는다.
		
		
		//여러분은 OR || 로 진행하다가 &&, & 하는 예쩨를 만들어 보세요.  &&와 &의 차이점과 short circuit을 설명할 수 있는 예제를 만들어보세요
		
		
		{
			int score = 85;
			char grade = score > 90 ? 'A' : 'B';
			grade = score >80 ? 'B':'C';
			
			System.out.println(grade);
		}
		
		//이거를 이렇게도 줄일 수 있잖아...제발
		{
			int score = 85;
			char grade = score > 90 ? 'A' : (score >80 ? 'B':'C');			
			
			System.out.println(grade);
		}
		
		//나눗셈
		{
			int a = 10;
			double b = a/3;
			System.out.println(b);
		}
		
		
		
		
	}
}

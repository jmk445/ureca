package methodchain;

public class Test {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		sb.append("def");
		
		//이런 식으로도 append를 할 수 있는데, 이런 식으로  
		sb.append("ghi").append("jkl"); 
		
		System.out.println(sb);
		
		
		//Calculator - patter 적용전
//		Calculator calc = new Calculator();
//		//3+5
//		calc.setFirst(3);
//		calc.setSecond(5);
//		
//		calc.add();
//		
//		
//		
		
		Calculator calc = new Calculator();
		//이런식으로 하고 싶다. 
//		calc.setFirst(3).add();
		//#1 그럴 려면 setFirst를 호출한 결과가 다시 calc 객체 자기 자신이면 해결됨. 
		
		calc.setFirst(3).setSecond(5).add();
	}
}

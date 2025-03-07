package ch07.methodpoly;

public class Test {	
	public static void main(String[] args) {
		MyClass mc = new MyClass();
		//그냥 이렇게 하면 mc.toString이 출력되고, 따로 재정의 하지 않으면 상위 클래스인 Object의 toString이 출력된다. 바로 주소가 출력되는 것이다.
		System.out.println(mc);
		
		Super s = new Sub();
		s.m3();
	}
}

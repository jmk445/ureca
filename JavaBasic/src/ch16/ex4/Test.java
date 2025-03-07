package ch16.ex4;

public class Test {
	
	//Method Reference <- Lambda 간단 표현식
	public static void main(String[] args) {
		Person person = new Person();
		
		//방법 1
		person.action((x,y) -> {
			return Computer.staticMethod(x, y);
		});
		
		
		//방법 2 : 방법 1 보다 더 간단
		person.action((x,y) -> Computer.staticMethod(x, y));
		
		
		//~~그러니까 Method reference를 이용하면,
		//어차피 xy인거 내가 알고, xy를 전달할 거를 내가 아니까, 이거만 써~ 라는 개념
		//파라미터와 그 사용이 명확할 때, 그냥 static method 그 자체를 보내버리는 
		person.action(Computer::staticMethod);
		
		
		//Computer 객체의 instance method를 호룰 1
		Computer computer = new Computer();
		person.action((x,y)-> {
			return computer.instanceMethod(x, y);	
		});
		
		
		//Computer 객체의 instance method를 호출 2 
		person.action((x,y) -> computer.instanceMethod(x, y));
		
		
		//Mehtod Reference(non static인 경우)
		//이것도 역시, 파라미터와 그 사용이 명확할 때
		//아무튼 이것도 메소드에서 functional interface를 parameter로 받는 경우, 그 호출이 일어날때, 사용)		//
		person.action(computer::instanceMethod);
	}
}

package ch13;

import java.util.Iterator;

import ch15.Board;

public class Test {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		box1.content = "Hello";
		
		Box<Integer> box2 = new Box<>();
		box2.content = 10;
		//box2 = "Hello"; //X
		
		
		Product <TV, String> product1 = new Product<>();
		product1.setKind(new TV());
		product1.setModel("OLED");
		
		Product<Car,String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("제네시스");
		
		
		
//		HomeAgency homeAgency = new HomeAgency();
//		Home home = homeAgency.rent();
//		
//		CarAgency carAgency = new CarAgency();
//		Car car = carAgency.rent();
		
		
		//인터페이스를 사용할 때는 위에 보다 이런식으로 쓰는게 다형성 측면에서 좋다. 
		//Test는 무슨 에이전시인지 관심이 없다. 
		//Home 이라고 들어가 있는데 무슨 차이냐? 위에는 클래스를 선언해준거기 때문에, Rentable에 있는 메소드만을 사용하고 싶다. 
		Rentable<Home> homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		
		Rentable<Car> carAgency = new CarAgency();
		Car car = carAgency.rent();
		
		
		//메소드와 generic
		//main() 별개의 static method 생성
		//Test 클래스에는 generic이 없다. 
		Box<Integer> box3 = boxing(100);
		System.out.println(box3.content);
		
		Box<String> box4 = boxing("Hello");
		System.out.println(box4.content);
		
		
		//제한된 generic T 
		System.out.println(compare(10,20));
		System.out.println(compare(10.5,20.4));
//		System.out.println(compare("hello","world"));//X
	}
	
	//메소드의 parameter에서 T를 쓰려면 앞에서 <ㅆ> 로 만들어 주어야한다. 그러면 안에서 쓸 수 도 있따. 
	//Box<T> 객체를 return 
	//Parameter로 T 타입의 객체를 받는다. 
	//앞에 이렇게 해놓으면 return 타입에서도 쓸 수 있고, parameter에서도 쓸수 있고 안에서도 쓸 ㅅ ㅜ있다.
	//인터페이스랑 클래스는 이름 뒤에 왔는데 이거는 아니다.
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<>();
		box.content = t;
		return box;
	}
	
	
	//T는 모든 타입의 객체가 아닌 Number를 포함한 하위클래스로 제한
	public static <T extends Number> boolean compare(T t1, T t2) {
		return t1.doubleValue() == t2.doubleValue();
	}
	
//	//super라는 키워드는 사용할 수 없다. 즉 상위 클래스로 제한할 수는 없다.
//	public static <T super Number> boolean compare2(T t1, T t2) {
//		return t1.doubleValue() == t2.doubleValue();
//	}	
	
//	
//	
//	Iterator<Board> itr2 = list.iterator();
//	while(itr2.hasNext()) {
//		Board board2 = itr2.hasNext();
//		if(board2.equals(board)) itr2.remove();
//	}

	
}

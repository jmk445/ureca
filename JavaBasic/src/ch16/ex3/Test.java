package ch16.ex3;

public class Test {
	public static void main(String[] args) {
		Person person = new Person();
		//원래는 calculable을 imple한 여러가지 클래스를 만들어야하는데, PErson의 action을 호출하면서 어떤일을 해야하는지는 parameter를 전달할때 정해주면 된다는 개념
		//parameter인 calculable인터페이스는 calculate만 할 수 밖에 없다는 것은 자명
		//이렇게 parameter로 interface를 받는게 중요 (앞에서와 동일)
		
		//그러니까 구조는 , functional interface를 parameter로 갖는 method를 호출할때 사용하는것이 람다 임. 
		
		//알고리즘 문제에서 정렬할 때, 정렬 조건을 람다식으로 많이 전달을 함. 
		
		//방법1
		person.action((x,y)->{
			return x+y;
		});
		
		//방법2 
		//return 문 생략
		person.action((x,y)-> x-y);
		
		
		person.action((x,y)-> x*y);
		
		//방법 3 (메소드를 사용하는 방법) (메소드를 넘겨주는 것, 어차피 행동) 
		
		person.action((x,y)->div(x,y));
	}
	
	public static int div(int x, int y) {
		return x/y;
	}
}

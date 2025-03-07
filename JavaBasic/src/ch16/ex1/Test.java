package ch16.ex1;

public class Test {
	public static void main(String[] args) {
		Person person = new Person();
		//한개이면 {} 생략 가능
		//원래는 Caculable을 구현한 객체를 넘겨주어야하는데 관심 없음 어차피 calculable은 한가지 메소드만 하기 때문에 
		person.action((name,job)->System.out.println(name + "이" + job + "을 수행합니다."));
		
				
	}
}

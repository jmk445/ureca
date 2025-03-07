package iterator;

//import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		StringContainer container = new StringContainer();
		
		//이런식으로 하려면 String Container가 Iterator 패턴이 적용이 돼있어야 가능하다.
		Iterator itr = container.getIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//StringContainer<MyClass> container = new StringContainer();
		
		
	}
}

//조별 워크샵에서 generic에서 wildcard(*) 부분 교재 코드 이행, 방금 StringContainer에 적용된 Iterator에 String 뿐만이 아닌 다른 타입도 적용가능하도록 generic을 적용해보기 

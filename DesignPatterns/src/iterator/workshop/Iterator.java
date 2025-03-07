package iterator.workshop;

//java.util에서 제공하는 Iteraotr 대신 우리만의 Iterator를 작성
//컬렉션을 순회하기 위한 메소드를 제공
public interface Iterator {
	//일단 has next 같은 메소드가 구현 필요
	boolean hasNext();
	Object next();//generic 적용 전
}

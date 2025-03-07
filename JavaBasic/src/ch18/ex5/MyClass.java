package ch18.ex5;

import java.io.Serializable;

//implement해도 무엇을 구현해라는 에러가 안뜸, 즉 , Serializable은 추상메소드가 없는 단순 마킹 용도
public class MyClass implements Serializable {
	/**
	 * 
	 */
	//이 버전 id를 올려버리면(변경) 그전 버전은 못쓰는게 된다. 
	private static final long serialVersionUID = 2L;
	
	int n;
	String str;
	
	
	transient String ssn;
	
	
	//serialbersionuid가 동일하면 추가된 필드가 있어도 역직렬화가 가능
	int n2;
	
	//serialbersionId가 직렬화 시점의 값과 다르면 역직렬화는 불가능
	
}

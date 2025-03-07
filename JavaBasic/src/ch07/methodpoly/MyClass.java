package ch07.methodpoly;

public class MyClass {
	int n;
	String str;
	
	@Override //annotation은 컴파일러에게 대화할 수 있는 도구, 오버라이드 할때는 권장사항. 해주는게 좋음
	public String toString() {
		return "n = "+ n + ", str = " + str;
	}

}

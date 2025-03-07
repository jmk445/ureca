package methodchain;

public class Calculator {
	private int first;
	private int second;
	//패턴 적용전 
//	public void setSecond(int second) {
//		this.second = second;
//	}
//	public void setFirst(int first) {
//		this.first = first;
//	}
//	public void add() {
//		System.out.println(this.first + this.second);		
//	}
//	public void sub() {
//		System.out.println(this.first - this.second);
//	}
	//패턴 적용 후
	public Calculator setSecond(int second) {
		this.second = second;
		return this;
	}
	public Calculator setFirst(int first) {
		this.first = first;
		return this;
	}
	public Calculator add() {
		System.out.println(this.first + this.second);
		return this;
	}
	public Calculator sub() {
		System.out.println(this.first - this.second);
		return this;
	}
	
}

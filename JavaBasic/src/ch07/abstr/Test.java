package ch07.abstr;

public class Test {
	public static void main(String[] args) {
		MyMouseAdaptor adaptor = new MyMouseAdaptor();
		adaptor.dblClick();
		adaptor.over();
		
		YourMouseAdaptor adaptor2 = new YourMouseAdaptor();
		
		adaptor2.dblClick();
		adaptor2.over();
	}

}

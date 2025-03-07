package singleton;

public class Test {
	public static void main(String[] args) {
		//Logger 객체가 단 한개만 만들어져야 한다.
		
		Logger logger = Logger.getInstance();
		logger.log("my message");
		
		
		Logger logger2 = Logger.getInstance();
		logger2.log("my message 2");
		
		System.out.println(logger == logger2);
	}
}

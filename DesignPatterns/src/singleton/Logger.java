package singleton;

import java.time.LocalDateTime;

public class Logger {	
	
	//#3 필드로 Logger 변수 필요
	//eager loading
//	private static Logger logger = new Logger();
	private static Logger logger;
	//#1 생성자를 private으로 
	private Logger() {}
	
	// #2 자신 객체를 생성, 전달하는 메소드를 제공해야함.
	public static Logger getInstance() {
		//이런 식으로 하면 결국 또 객체를 만드는 거임
//		return Logger
		//static 으로 해서 Logger 객체 생성 없이 호출 가능
		if(logger == null) {
			logger = new Logger();
		}
		return logger;		
	}
	
	public void log(String message) {
        LocalDateTime ldt = LocalDateTime.now();
        String date = ldt.getYear() + "/" + ldt.getMonthValue() + "/" + ldt.getDayOfMonth();
        String time = ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond();
        
        System.out.println("[" + date + " " + time + "] " + message);
    }
}

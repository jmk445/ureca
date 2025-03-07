//package ch16;
//
//public class Test {
//	
//	
//	public static void main(String[] args) {
////		Calculable calcPlus = new CalculablePlus();
////		calcPlus.calculate(10, 20);
////		
////		Calculable calcMinus = new CalculableMinus();
////		calcMinus.calculate(10, 20);				
//		
//		
//		Calculable calcPlus = new CalculablePlus();
//		action(calcPlus);
//		Calculable calcMinus = new CalculableMinus();
//		action(calcMinus);
//		
//		
//		//굳이 이렇게 까지...
//		//익명 클래스 객체를 이용 덧셈
//		
//		action(new Calculable(){
//			@Override
//			public void calculate(int x, int y) {
//				System.out.println(x+y);
//			}
//		});
//		
//		
//		//한 단계더 간단히
//		
//		//컴파일러 입장에서는 functional interfgace를 구현한 객체를 어떻게 처리할 지는
//		//그러니까 functional interface를 구현하는 애들은 굳이 객체를 안만들고 그것이 구현해야하는 단 한가지의 메소드의 내용물만 전달해주면 됨
//		
//		action((x,y) -> {System.out.println(x+y);});
//	}
//	
//	//functional interface를 parameter로 받게 함. 이때, 이 parameter로 할 수 있는 것은 딱 하나의 메소드 밖에 호출을 못한다. 
//	public static void action(Calculable calculable) {
//		//하나의 메소드만 호출 가능 
//		calculable.calculate(10, 20);
//	}
//
//}


//강사님 코드 
package ch16;
public class Test {
    
    public static void main(String[] args) {
//      // Calculable 구현 클래스 이용 덧셈
//      Calculable calcPlus = new CalculableImplPlus();
//      calcPlus.calculate(10, 20);
//      
//      // Calculable 구현 클래스 이용 뺄셈
//      Calculable calcMinus = new CalculableImplMinus();
//      calcMinus.calculate(10, 20);
        // Calculable 구현 익명 클래스 이용 덧셈
        Calculable calcPlusAnony = new Calculable() {
            @Override
            public void calculate(int x, int y) {
                System.out.println(x + y);
            }
            
        };
        calcPlusAnony.calculate(10, 20);
        
        // Calculable 구현 람다 이용 덧셈
        Calculable calcPlusLambda = (x, y) -> { 
            System.out.println( x + y );
        };
        calcPlusLambda.calculate(10, 20);
        
        
        // action method 의 파라미터에 functional interface
        
        // Calculable 파라미터를 가진 메소드 호출
        Calculable calcPlus = new CalculablePlus();
        action(calcPlus);
        
        // Calculable 파라미터를 가진 메소드 호출
        Calculable calcMinus = new CalculableMinus();
        action(calcMinus);
        
        // 굳이 이렇게까지...
        // 익명 클래스 객체를 이용 덧셈
        action(new Calculable() {
            @Override
            public void calculate(int x, int y) {
                System.out.println(x + y);
            }            
        });
        // 익명 클래스 객체를 이용 뺄셈
        action(new Calculable() {
            @Override
            public void calculate(int x, int y) {
                System.out.println(x - y);
            }
            
        });
        
        // 한 단계 더 간단히...
        // 컴파일러 입장에서는 Functional Interface 를 구현한 객체를 어떻게 처리할 지는
        // 인터페이스에 있는 메소드의 파라미터와 그것을 구현하는 코드
        action( (x, y) -> { System.out.println(x + y); }   ); // 덧셈
        action( (x, y) -> { System.out.println(x - y); }   ); // 뺄셈
        // 람다는 FunctionalInterface 에만 사용
    }
    // Funcional Interface 타입의 파라미터
    public static void action(Calculable calculable) {
        // 하나의 메소드만 호출 가능
        calculable.calculate(10, 20);
    }
    
    
    
}









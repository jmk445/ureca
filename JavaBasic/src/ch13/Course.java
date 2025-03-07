package ch13;


public class Course {
	//과목 등록
	//와일드 카드 타입 파라미터 
	//Course가 generic 타입을 사용x
	//but, Course의 메소드가 파라미터를 갖는데, 그 파라미터 타입(Applicant)이 generic 타입을 가진다.
    public static void registerCourse1(Applicant<?> applicant) {
        System.out.println(applicant.kind);
    }
    
    public static void registerCourse2(Applicant<? extends Student> applicant) {
            
    }
    
    public static void registerCourse3(Applicant<? super Worker> applicant) {
        
    }
}









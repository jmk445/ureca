package ch05;
public class Test2 {
    public static void main(String[] args) {
        // String 객체의 비교
//      {
//          String str1 = new String("Hello"); // heap 100 주소에 문자열 객체 생성 
//          String str2 = new String("Hello"); // heap 200 주소에 문자열 객체 생성 
//          String str3 = "Hello"; // heap 300 주소에 문자열 객체 생성 
//          String str4 = "Hello"; // heap 300 주소에 있는 문자열 사용 
//
//          // ==
//          System.out.println(str1 == str2);
//          System.out.println(str3 == str4);
//          System.out.println(str1 == str4);
//          
//          // equals()
//          System.out.println(str1.equals(str2)); // heap 위치와 상관없이 문자열 내용 비교
//          System.out.println(str3.equals(str4)); // heap 위치와 상관없이 문자열 내용 비교
//          System.out.println(str1.equals(str4)); // heap 위치와 상관없이 문자열 내용 비교
//          
//          // MyClass 객체의 equals() 비교
//          MyClass mc1 = new MyClass();
//          mc1.name = "Hello";
//          MyClass mc2 = new MyClass();
//          mc2.name = "Hello";
//          
//          System.out.println(mc1.name);
//          System.out.println(mc2.name);
//          System.out.println(mc1.equals(mc2)); // false <= 같은 참조 타입의 객체가 무조건 equals() 로 내용비교가 true 가 되는 건 아니다.
//      }
        
        // String 의 다양한 메소드
        {
            String str = "Hello";
            
            // length()         
            System.out.println(str.length());
            
            // charAt()
            System.out.println(str.charAt(0)); // 범위를 벗어 나면 StringIOBE 발생
            
            // replace()
            System.out.println(str.replace("l", "X")); // 새로운 문자열 return
            System.out.println(str);
            
            // indexOf()
            System.out.println(str.indexOf("l")); // 2
            
            // substring()
            System.out.println(str.substring(0, 2));
            System.out.println(str.substring(0, str.indexOf("l")) + "X" + str.substring(str.indexOf("l") + 1, str.length()));
        }
        
    }
}

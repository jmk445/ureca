package ch18.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	public static void main(String[] args) {
	//	try {
	//        OutputStream os = new FileOutputStream("C:/Temp/test1.db");
	//        
	//        byte a = 10;
	//        byte b = 20;
	//        byte c = 30;
	//        
	//        os.write(a);
	//        os.write(b);
	//        os.write(c);
	//        
	//        os.flush();
	//        os.close();
	//        
	//    }catch(IOException e) {
	//        System.out.println(e);  
	//        e.printStackTrace();
	//    }
	//	
		
		 try {
	         InputStream is = new FileInputStream("C:/Temp/test1.db");
	         // write 할 때 3개 했다는 걸 알고 있는 경우
	//       byte a = (byte)is.read();
	//       byte b = (byte)is.read();
	//       byte c = (byte)is.read();
	//       System.out.println(a);
	//       System.out.println(b);
	//       System.out.println(c);
	         
	         // 몇 개인지 모를 때
	         while(true) {
	             int data = is.read();
	             if( data == -1 ) break;
	             System.out.println(data);
	         }
	         
	         is.close();
	         
	     }catch(IOException e) {
	         System.out.println(e);  
	         e.printStackTrace();
	     }
	
	}
}

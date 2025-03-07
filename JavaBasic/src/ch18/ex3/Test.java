package ch18.ex3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	public static void main(String[] args) throws Exception{
		// copy() 입출력 stream
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		OutputStream os = new FileOutputStream("C:/Temp/test2.txt");
		
		// copy() 입출력 + buffer stream
		InputStream is2 = new FileInputStream("C:/Temp/test.txt");
		OutputStream os2 = new FileOutputStream("C:/Temp/test2.txt");
		BufferedInputStream bis = new BufferedInputStream(is2);
		BufferedOutputStream bos = new BufferedOutputStream(os2);
		
		//buffer를 이용하지 않는 작업
		long nonBufferTime = copy(is, os);
		System.out.println(nonBufferTime);
		
		//buffer를 이용하는 작업
		long bufferTime = copy(bis, bos);
		System.out.println(bufferTime);
		
		//buffer를 이용한 것이 훨씬 빠르다.
//		59475800
//		882600
		is.close();
		os.close();
		
		bis.close();
		bos.close();
		is2.close();
		os2.close();
		
	}

	public static long copy(InputStream is, OutputStream os) throws Exception{
		long start = System.nanoTime();
		//복사
		while(true) {
			int data = is.read();
			if( data == -1 ) break;
			os.write(data);
		}
		
		long end = System.nanoTime();
		
		return end - start;
	}
}

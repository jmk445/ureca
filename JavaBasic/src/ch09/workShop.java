package ch09;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class workShop {
	public static void main(String[] args) {
		try (FileInputStream fis= new FileInputStream("test.txt")) {
			int data = fis.read();	
			System.out.println((char) data);	
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

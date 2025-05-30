package ch15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//linked list vs arrayList

public class Test2 {
	public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        // Test ArrayList vs LinkedList
        long startTime;
        long endTime;
        
        
        //맨앞에 계속 추가
        //ArrayList는 인덱스 조정작업 발생 그래서 이거는 linkedlist가 훨신 빠름
        startTime = System.nanoTime();      
        for (int i = 0; i < 300000; i++) {
            arrayList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        

        startTime = System.nanoTime();      
        for (int i = 0; i < 300000; i++) {
            linkedList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        //뒤에서 순차적으로 추가 
        //이거는 Arrraylist가 훨씬 빠름
        startTime = System.nanoTime();      
        for (int i = 0; i < 500000; i++) {
            arrayList.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        

        startTime = System.nanoTime();      
        for (int i = 0; i < 500000; i++) {
            linkedList.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        
        
        

	}
}

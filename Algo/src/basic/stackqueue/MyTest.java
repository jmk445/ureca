package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MyTest {
	public static void main(String[] args) {
		Deque<int[]> stack = new ArrayDeque<>();
		
		
		stack.push(new int[] {1,2,3});
		//들여다보기
		int[] array = stack.peek();
		//빼내기
		stack.pop();
		
		
		Queue<int[]> queue = new ArrayDeque<>();
	}
		
}

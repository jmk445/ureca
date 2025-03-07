package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test1 {
	public static void main(String[] args) {
		{
//			Stack<Integer> stack = new Stack<>();
//			
//			stack.push(3);
//			System.out.println(stack.peek());
//			System.out.println(stack.size());
//			
//			System.out.println();
//			stack.push(1);
//			System.out.println(stack.peek());
//			System.out.println(stack.size());
//			
//			System.out.println();
//			stack.push(7);
//			System.out.println(stack.peek());
//			System.out.println(stack.size());
//			
//			
//			System.out.println();
//			Integer num = stack.pop();
//			System.out.println(num);
//			System.out.println(stack.peek());
//			System.out.println(stack.size());
//			
//			
//			//순회		
//			while(!stack.isEmpty() ) {
//				System.out.print(stack.pop() + " ");
//			}
//			
		}
		{
			//stack using Deque
			Deque<Integer> stack = new ArrayDeque<>();
			
			stack.push(3);
			System.out.println(stack.peek());
			System.out.println(stack.size());
			
			System.out.println();
			stack.push(1);
			System.out.println(stack.peek());
			System.out.println(stack.size());
			
			System.out.println();
			stack.push(7);
			System.out.println(stack.peek());
			System.out.println(stack.size());
			
			
			System.out.println();
			Integer num = stack.pop();
			System.out.println(num);
			System.out.println(stack.peek());
			System.out.println(stack.size());
			
			
			//순회		
			while(!stack.isEmpty() ) {
				System.out.print(stack.pop() + " ");
			}
		}
	}
}

package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test2 {
	public static void main(String[] args) {
		{
//			Queue<Integer> queue = new LinkedList<>();
//			
//			queue.offer(3);
//			System.out.println(queue.peek());
//			System.out.println(queue.size());
//			
//			System.out.println();
//			queue.offer(1);
//			System.out.println(queue.peek());
//			System.out.println(queue.size());
//			
//			System.out.println();
//			queue.offer(7);
//			System.out.println(queue.peek());
//			System.out.println(queue.size());
//			
//			
//			System.out.println();
//			Integer num = queue.poll();
//			System.out.println(num);
//			System.out.println(queue.peek());
//			System.out.println(queue.size());
//			
//			System.out.println();
//			//순회		
//			while(!queue.isEmpty() ) {
//				System.out.print(queue.poll() + " ");
//			}
			
		}
		
		//Queue using Deque
		{
			Deque<Integer> queue = new ArrayDeque<>();
			
			
			//나머지(메소드)는 똑같다. 이것이 바로 다형성, 인터페이스의 장저 
			queue.offer(3);
			System.out.println(queue.peek());
			System.out.println(queue.size());
			
			System.out.println();
			queue.offer(1);
			System.out.println(queue.peek());
			System.out.println(queue.size());
			
			System.out.println();
			queue.offer(7);
			System.out.println(queue.peek());
			System.out.println(queue.size());
			
			
			System.out.println();
			Integer num = queue.poll();
			System.out.println(num);
			System.out.println(queue.peek());
			System.out.println(queue.size());
			
			System.out.println();
			//순회		
			while(!queue.isEmpty() ) {
				System.out.print(queue.poll() + " ");
			}

		}
	}
}

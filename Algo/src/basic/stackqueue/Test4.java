package basic.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class Test4 {
	public static void main(String[] args) {
		//int[]를 stack, queue활용
		{
			Deque<int[]> stack = new ArrayDeque<>();
			stack.push(new int[] {3,0,4});
			stack.push(new int[] {2,8,1});
			stack.push(new int[] {1,6,3});
			stack.push(new int[] {5,5,10});
			
			System.out.println(Arrays.toString(stack.pop()));
			System.out.println(Arrays.toString(stack.peek()));
			
			System.out.println(new int[] {9,0,3});
			
			
			while(!stack.isEmpty()) {
				System.out.println(Arrays.toString(stack.pop()));
			}			
		}
		
		//queue
		{
			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {3,0,4});
			queue.offer(new int[] {2,8,1});
			queue.offer(new int[] {1,6,3});
			queue.offer(new int[] {5,5,10});
			
			System.out.println(Arrays.toString(queue.poll()));
			System.out.println(Arrays.toString(queue.peek()));
			
			System.out.println(new int[] {9,0,3});
			
			
			while(!queue.isEmpty()) {
				System.out.println(Arrays.toString(queue.poll()));
			}			
		}
	}
		
}

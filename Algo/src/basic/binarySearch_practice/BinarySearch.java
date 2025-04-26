package basic.binarySearch_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	static List<Integer> list;
	public static void main(String[] args) throws Exception{
		list = new ArrayList<Integer> ();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i ++) {
			list.add(i);
		}
		long beforeTime = System.currentTimeMillis();
		int answer = binarySearch(target, 0, N);
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime) / 1000;
		System.out.println(answer);
		System.out.println(secDiffTime);
	}
	
	static int binarySearch(int key, int low, int high) {
		int mid;
		if(low <= high) {
			mid = (low + high) / 2;
			if(key == list.get(mid)) {
				return mid;
			}else if(key < list.get(mid) ){
				return binarySearch(key, low, mid - 1);
			}else {
				return binarySearch(key, mid+1, high);
			}
		}
		return 0;
	}
}

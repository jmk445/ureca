package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P5639 {
	public static void main(String[] args) throws IOException{
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input = br.readLine();
//		while(input != null ) {
//			arr.add(Integer.parseInt(input));
//			input = br.readLine();
//		}
//		
//		Integer[] graph = arr.toArray(new Integer[0]);
//		
//		Arrays.sort(graph);
		
		//이렇게 하면, 같은 크기 비교 상태여도, 여러개의 그래프가 나오기 떄문에, 정답이 여러 개가 된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String line;
        
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            list.add(Integer.parseInt(line.trim()));
        }
        
        int[] graph = list.stream().mapToInt(i -> i).toArray();
        
        Arrays.sort(graph);
        
        System.out.println(Arrays.toString(graph));
        
        System.out.print(graph[0]);
        for(int i = 1; i < graph.length/2; i+=2) {        	
        	System.out.print(graph[i+i%2]);
        	System.out.print(graph[i+i%2-1]);
        }
        
        for(int i = graph.length-1; i>= graph.length/2; i--) {
        	
        }
        
	}
}

package boj.p2839_설탕공장_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839_DS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
				
		while(true) {
			if( N < 0 ) { // 3  과 5 로 만들지 못하는 경우
                System.out.println(-1);
                break;
            }
            
            // N 을 5 나누어 떨어지는지 
			//그러니까 결론은 큰거 부터 최대한 사용하고 나머지는 작은걸로 처리해도 되는 문제는 그리디 
            if( N % 5 == 0 ) {
                System.out.println( N / 5 + cnt);
                break;
            }
            
            // 3 하나 사용
            N -= 3;
            cnt++;
		}
						
		 
	}
}

package boj.p1149_rgb거리_dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] cost = new int[N][3];
        for(int i = 0 ; i < N ; i ++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	cost[i][0] = Integer.parseInt(st.nextToken());
        	cost[i][1] = Integer.parseInt(st.nextToken());
        	cost[i][2] = Integer.parseInt(st.nextToken());
        }
        
        
        int[] cost_noojeok = new int[N];
        
        int color_before = 0;
        for(int i = 1; i < N; i++) {
//        	cost_nookeok[1] = //
        	
        	int num1 = cost[i][0];
        	int num2 =cost[i][1];
        	int num3 = 	cost[i][2];
        	int min = 0;
        	if(num1 < num2) {
        		min = num1;
        	}else{
        		
        		min = num2;
        		
        	}
        	
        				        	
        	//i번째 집의 최솟값으로 칠하는 cost, 색 구하기
//        	int min = (num2>num1)&&(num3>num1)?num1:(num2>num3?num3:num2);
        	
//        	int color = ;
//        	//그 
//        	if(color == cost_before) {
        		//i번째 color를 한것과 i-1번째에서 color말고 최솟값을 한 값을 비교
        		//더 작은 값을 cost_nookeok[i]에 대입
        	}
        			
        }
	}
//}

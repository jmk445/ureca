package boj.p9663_Nqueen_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9663_DS {

	static int N, ans;
    static int[] rowColumns; // rowColumns[2] = 4 <= 2번 row에 현재 놓은 Queen column 값이 4
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        rowColumns = new int[N]; // N 개 row에 대해
        
        dfs(0); // 0 번째 row 시작
        
        System.out.println(ans);
		

    }
    static void dfs(int row) {
        // 기저조건
        // 이전단계에서 마지막 행까지 다 놓았으면
        if( row == N ) {
            ans++;
            return;
        }
        
        // 현재 row 행에 Queen 을 놓아본다. ( 옆으로 column 에 한자리씩 놓아본다. )
        for (int i = 0; i < N; i++) {
            rowColumns[row] = i; // 한 행에는 한 개의 Queen 만 놓고 있다. (가로로 겹치지는 않는다.)
            // 유망 함수를 호출해서 가능하면 다음 row 로 계속 이어간다.
            if( check(row) ) { // false 인 경우 가지치기 발생
                dfs( row + 1 );
            }
        }
    }
    
    // 유망 함수
    // 현재 row 에 rowColumns 에 저장된 이전 row의 Queen 자리를 포함해서 가능한지 따져본다.
    static boolean check(int row) {
        // 시작 row 부터 현재 row 까지
        for (int i = 0; i < row; i++) {
            // 세로로 겹치는 지
            if( rowColumns[i] == rowColumns[row] ) return false;
            
            // 대각선으로 겹치는 지
            // 행의 변화량 == 열의 변화량
            else if( row - i == Math.abs(rowColumns[i] - rowColumns[row])) return false;
        }
        
        return true;
    }
}

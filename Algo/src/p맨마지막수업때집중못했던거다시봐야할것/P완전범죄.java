package p맨마지막수업때집중못했던거다시봐야할것;

public class P완전범죄 {
	class Solution {
		   public int solution(int[][] info, int n, int m) {
		       // dp[a][b]: A도둑이 a개, B도둑이 b개의 흔적을 남겼을 때 
		       // 모든 물건을 훔칠 수 있는지 여부를 저장하는 배열
		       boolean[][] dp = new boolean[n][m];
		       // 초기 상태 설정 (아무 흔적도 없는 상태)
		       dp[0][0] = true;
		       
		       // 각 물건에 대해 반복
		       for (int i = 0; i < info.length; i++) {
		           // 다음 상태를 저장할 배열
		           boolean[][] next = new boolean[n][m];
		           
		           // 현재 가능한 모든 흔적 상태에 대해 반복
		           for (int a = 0; a < n; a++) {
		               for (int b = 0; b < m; b++) {
		                   // 현재 상태가 불가능한 경우 스킵
		                   if (!dp[a][b]) continue;
		                   
		                   // A도둑이 물건을 훔치는 경우
		                   int na = a + info[i][0];
		                   if (na < n) {  // A도둑이 경찰에 붙잡히지 않는 경우
		                       next[na][b] = true;
		                   }
		                   
		                   // B도둑이 물건을 훔치는 경우
		                   int nb = b + info[i][1];
		                   if (nb < m) {  // B도둑이 경찰에 붙잡히지 않는 경우
		                       next[a][nb] = true;
		                   }
		               }
		           }
		           // 다음 상태를 현재 상태로 업데이트
		           dp = next;
		       }
		       
		       // 가능한 모든 상태 중 A도둑의 흔적이 최소인 값 찾기
		       int answer = Integer.MAX_VALUE;
		       for (int a = 0; a < n; a++) {
		           for (int b = 0; b < m; b++) {
		               if (dp[a][b]) {
		                   answer = Math.min(answer, a);
		               }
		           }
		       }
		       // 불가능한 경우 -1 반환
		       return answer == Integer.MAX_VALUE ? -1 : answer;
		   }
		}
}

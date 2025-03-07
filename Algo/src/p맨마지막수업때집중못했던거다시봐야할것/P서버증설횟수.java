package p맨마지막수업때집중못했던거다시봐야할것;

public class P서버증설횟수 {
	class Solution {
		   public int solution(int[] players, int m, int k) {
		       // 총 서버 증설 횟수
		       int answer = 0;
		       // 현재 운영 중인 서버 수
		       int serverCounts = 0;
		       // 각 시간대별로 반납되는 서버 수를 저장하는 배열
		       // k시간 후에 서버가 반납되므로 players.length + k 크기로 선언
		       int[] deactivate = new int[players.length + k];
		       
		       // 0시부터 23시까지 순회
		       for (int time = 0; time < players.length; time++) {
		           // 현재 시간에 반납되어야 하는 서버 수만큼 감소
		           serverCounts -= deactivate[time];
		           
		           // 현재 시간대의 이용자를 수용하기 위해 필요한 서버 수 계산
		           // m명당 1대의 서버가 필요하므로 players[time] / m
		           int requireServerCounts = players[time] / m;
		           
		           // 필요한 서버 수가 현재 운영 중인 서버 수보다 많다면
		           if (requireServerCounts > serverCounts) {
		               // 추가로 필요한 서버 수 계산
		               int addServerCounts = requireServerCounts - serverCounts;
		               // 현재 운영 중인 서버 수 증가
		               serverCounts += addServerCounts;
		               // 총 증설 횟수에 추가
		               answer += addServerCounts;
		               // k시간 후에 반납될 서버 수 기록
		               deactivate[time + k] += addServerCounts;
		           }
		       }
		       return answer;
		   }
		}
}

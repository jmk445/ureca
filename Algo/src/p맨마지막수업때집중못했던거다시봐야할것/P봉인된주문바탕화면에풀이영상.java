package p맨마지막수업때집중못했던거다시봐야할것;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P봉인된주문바탕화면에풀이영상 {
	class Solution {
		   public String solution(long n, String[] bans) {
		       // n번째 위치를 찾기 위한 변수
		       long ansPos = n;
		       
		       // 금지된 주문들의 위치(숫자)를 저장할 리스트
		       List<Long> banPositions = new ArrayList<>();
		       
		       // 각 금지된 주문을 26진수로 변환하여 저장
		       // 예: "abc" -> (1 * 26^2) + (2 * 26^1) + (3 * 26^0)
		       for (String ban : bans) {
		           banPositions.add(alphabet26ToDecimal(ban));
		       }
		       
		       // 금지된 위치들을 오름차순으로 정렬
		       Collections.sort(banPositions);
		       
		       // 금지된 주문들로 인해 실제 위치가 얼마나 밀려났는지 계산
		       // 현재 위치보다 작거나 같은 금지된 위치가 있다면,
		       // 그만큼 답의 위치가 뒤로 밀림
		       for (long pos : banPositions) {
		           if (pos <= ansPos) ansPos++;
		           else break;
		       }
		       
		       // 최종 위치를 다시 알파벳 문자열로 변환하여 반환
		       return decimalToAlphabet26(ansPos);
		   }
		   
		   // 알파벳 문자열을 26진수로 변환하는 메서드
		   public static long alphabet26ToDecimal(String s) {
		       long result = 0;
		       for (int i = 0; i < s.length(); i++) {
		           // 각 자리수마다 26을 곱하고 현재 알파벳의 위치값(1~26)을 더함
		           result = result * 26 + (s.charAt(i) - 'a' + 1);
		       }
		       return result;
		   }
		   
		   // 26진수를 알파벳 문자열로 변환하는 메서드
		   public static String decimalToAlphabet26(long n) {
		       StringBuilder sb = new StringBuilder();
		       while (n > 0) {
		           // 1을 빼는 이유: 'a'가 1이 아닌 0부터 시작하도록 하기 위함
		           n--;
		           int remainder = (int)(n % 26);
		           // 나머지를 알파벳으로 변환하여 추가
		           sb.append((char)('a' + remainder));
		           n /= 26;
		       }
		       // 역순으로 되어있는 문자열을 뒤집어서 반환
		       return sb.reverse().toString();
		   }
		}
}

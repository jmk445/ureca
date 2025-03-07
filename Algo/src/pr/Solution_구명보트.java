package pr;

import java.util.Arrays;

public class Solution_구명보트 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int count = 0;
		int i = 0;
		int j = people.length -1;
		
		while(i<= j) {
			if(people[i] + people[j] <= limit) {
				i++;
			}
			j--;
			count++;
		}
					
	return count;
	}

}

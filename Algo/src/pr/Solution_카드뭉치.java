package pr;


//Queue 등 자료구조 사용 X, 주어진 배열 cards1, cards2 를 이용해서 처리
public class Solution_카드뭉치 {
 public String solution(String[] cards1, String[] cards2, String[] goal) {
     int idx1 = 0;
     int idx2 = 0;
     int idxG = 0;
     
     while(true) {
         // 맨 앞부터 배열의 index 를 이용해서 2개의 배열 문자열과 goal 문자열 비교
         if( idxG == goal.length ) return "Yes";
         
         String curr = goal[idxG];
         
         if( idx1 <= cards1.length - 1 && curr.equals(cards1[idx1])) {
             idxG++;
             idx1++;
         } else if( idx2 <= cards2.length - 1 && curr.equals(cards2[idx2])) {
             idxG++;
             idx2++;
         }else {
             return "No";
         }
     }
 }
}
/*
테스트 1 〉 통과 (0.48ms, 82.7MB)
테스트 2 〉 통과 (0.58ms, 82.5MB)
테스트 3 〉 통과 (0.38ms, 83.3MB)
테스트 4 〉 통과 (0.46ms, 82.5MB)
테스트 5 〉 통과 (0.58ms, 76.9MB)
테스트 6 〉 통과 (0.44ms, 87.2MB)
테스트 7 〉 통과 (0.61ms, 88MB)
테스트 8 〉 통과 (0.76ms, 85.6MB)
테스트 9 〉 통과 (0.41ms, 74.9MB)
테스트 10 〉    통과 (0.74ms, 100MB)
테스트 11 〉    통과 (0.61ms, 77.8MB)
테스트 12 〉    통과 (0.46ms, 80.7MB)
테스트 13 〉    통과 (0.61ms, 84.9MB)
테스트 14 〉    통과 (0.62ms, 73.6MB)
테스트 15 〉    통과 (0.44ms, 83.7MB)
테스트 16 〉    통과 (0.45ms, 77.9MB)
테스트 17 〉    통과 (0.56ms, 83.8MB)
테스트 18 〉    통과 (0.57ms, 75.7MB)
테스트 19 〉    통과 (0.47ms, 71.9MB)
테스트 20 〉    통과 (0.43ms, 85.9MB)
테스트 21 〉    통과 (0.58ms, 84.7MB)
테스트 22 〉    통과 (0.45ms, 73.2MB)
테스트 23 〉    통과 (0.50ms, 82.3MB)
테스트 24 〉    통과 (0.42ms, 81.9MB)
테스트 25 〉    통과 (0.62ms, 86.4MB)
테스트 1 〉 통과 (0.01ms, 84.1MB)
테스트 2 〉 통과 (0.02ms, 82.6MB)
테스트 3 〉 통과 (0.01ms, 75.6MB)
테스트 4 〉 통과 (0.01ms, 88.3MB)
테스트 5 〉 통과 (0.02ms, 77.9MB)
테스트 6 〉 통과 (0.02ms, 74.5MB)
테스트 7 〉 통과 (0.02ms, 92.6MB)
테스트 8 〉 통과 (0.01ms, 76.8MB)
테스트 9 〉 통과 (0.01ms, 84.9MB)
테스트 10 〉    통과 (0.01ms, 86.2MB)
테스트 11 〉    통과 (0.02ms, 90.6MB)
테스트 12 〉    통과 (0.02ms, 88.5MB)
테스트 13 〉    통과 (0.02ms, 93MB)
테스트 14 〉    통과 (0.02ms, 73.2MB)
테스트 15 〉    통과 (0.01ms, 80.8MB)
테스트 16 〉    통과 (0.01ms, 87.8MB)
테스트 17 〉    통과 (0.02ms, 82.9MB)
테스트 18 〉    통과 (0.02ms, 74.9MB)
테스트 19 〉    통과 (0.02ms, 78.1MB)
테스트 20 〉    통과 (0.02ms, 101MB)
테스트 21 〉    통과 (0.01ms, 70.3MB)
테스트 22 〉    통과 (0.02ms, 89.3MB)
테스트 23 〉    통과 (0.02ms, 77MB)
테스트 24 〉    통과 (0.01ms, 79.2MB)
테스트 25 〉    통과 (0.02ms, 87.7MB)
*/
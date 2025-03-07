package ch15;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
	public static void main(String[] args) {
		Set<Board> boardSet = new HashSet<>();
		boardSet.add(new Board("제목 1", "내용 1", "작성자1"));
		boardSet.add(new Board("제목 2", "내용 2", "작성자2"));
		boardSet.add(new Board("제목 3", "내용 3", "작성자3"));
		boardSet.add(new Board("제목 4", "내용 4", "작성자4"));
		boardSet.add(new Board("제목 3", "내용 3", "작성자3"));
		boardSet.add(new Board("제목 4", "내용 4", "작성자4"));
		
		//custom class객체일 경우 equals화 hash를 정의를 해놓아야 제대로 set이 동작(중복을 허용하지 않음)
		
		for(Board board : boardSet) {
			System.out.println(board);
		}
	}

}

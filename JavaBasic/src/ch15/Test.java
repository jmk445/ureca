package ch15;


import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		//List-ArrayList
		List <Board> list = new ArrayList<>();
		list.add(new Board("제목 1", "내용 1", "작성자1"));
		list.add(new Board("제목 2", "내용 2", "작성자2"));
		list.add(new Board("제목 3", "내용 3", "작성자3"));
		list.add(new Board("제목 4", "내용 4", "작성자4"));
		
						
		//list.toString이 호출되고, 그 것은 각 객체의 toString을 호출하는 듯. 
		//그래서 각 객체의 toString이 구현돼있어야함. 
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(2)); 
		
		
		//중복 가능 확인
		//heap 에 있는 같은 주소의 객체를 삽입할 수 있음 
		Board board = new Board("제목 5", "내용 5", "작성자5");
		list.add(board);
		System.out.println(list.size());
		list.add(board);
		System.out.println(list.size());
		System.out.println(list);
		
		
		list.remove(new Board("제목3","내용3", "작성자3")); //내부적으로 전달되는 객체의 equals()로 처리를 함, but equals가 없기 때문에 삭제 안됨. 재정의를 안했기 때문에 주솟값이 같은 거로 찾게됨. 그러나 새로운 주소값을 찾는 것이라서 없음
		
		
		list.remove(board); //이거는 됨. 왜냐하면, 주솟값을 제대로 가지고 있기 때문, 위에 거는 삭제가 안된것은 새로운 주소값을 삭제하고 싶다고 해서 안된 것임.
		
		
	}
}

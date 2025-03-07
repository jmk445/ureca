package builder;

public class Test {
	public static void main(String[] args) {
		
		
		//필요한 생성자가 많아지게됨
//		Board board1 = new Board();
//		Board board2 = new Board("~~~~", "~~~")
		
		//패턴 적용 후
		//Board.Builder() : 기본 생성자 호출
		//만약에 나는 제목 까지만 만들겠다~ 하면 저기서 build 바로 하고. 
		Board board1 = new Board.Builder()
						.title("제목1")
						.content("내용1")
						.build();
		System.out.println(board1);
	}
}

package builder;
//Builder pattern 은 필드가 많아지면 생성자 이슈 발생 <= 객체 생성 시점에 필요한 다양한 생성자를 제공하기 어려워짐.
//생성자를 통하지 않고 좀 더 효율적으로 객체를 생성할 것인가?
public class Board {
	private String title;
	private String content;
	private String writer;
	
	//builder patter 적용전
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getWriter() {
//		return writer;
//	}
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//	public Board(String title, String content, String writer) {
//		super();
//		this.title = title;
//		this.content = content;
//		this.writer = writer;
//	}

	
	
	//#4. 이제 builder의 필드를 board의 필드로 전달하기 위해서 특별한 생성자
	//#5. 이제 이러면 객체를 생성할때 여러가지 생성자를 '우아하게' 사용할 수 있음 
	private Board(Builder builder) {
		this.title = builder.title;
		this.content = builder.content;
		this.writer = builder.writer;
	}
	

	//#1 필드와 동일한 필드를 가지는 static inner class 생성		
	public static class Builder{
		private String title;
		private String content;
		private String writer;
		
		//#2 method chain 방식으로 필드별 메소드를 생성(이름도 동일하게)
		public Builder title(String title) {
			this.title = title;
			return this;			
		}
		
		public Builder content(String content){
			this.content = content;
			return this;
		}
		
		public Builder writer(String writer) {
			this.writer = writer;
			return this;
		}
		//#3. 이제 이런식으로 Build의 필드가 채워졌고, 이걸 Board의 필드에 전달해야함.
		public Board build() {
			return new Board(this);
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
}

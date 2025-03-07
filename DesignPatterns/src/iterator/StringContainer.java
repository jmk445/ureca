package iterator;

public class StringContainer implements Container{
	String[] strArray = {"Hello", "Iterator", "asdf"};
	
	//#1. container를 implement했더니만 구현해댜하는 메소드이고, 
	@Override 
	public Iterator getIterator() {
		// #2. 그러고 return 값을 보니까 Iterator를 구현한 객체가 필요해서
		return new StringIterator();
	}
	
	
	//#3. 클래스 내부에 private Iterator 구현 클래스 정의
	private class StringIterator implements Iterator{
		
		int index; //default 0 //strArray에서 현재 들여다 보는 객체
		@Override
		public boolean hasNext() {
			if (index < strArray.length) return true;			
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) return strArray[index++];
			return null;
		}
		
	}
	
	
}

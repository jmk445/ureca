package iterator;


public interface Container {
	//제공되는 iterator가 아니라 우리가 정의한 iterator를 쓴다.
	Iterator getIterator();
}

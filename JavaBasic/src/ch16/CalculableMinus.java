package ch16;

public class CalculableMinus implements Calculable{
	@Override
	public void calculate(int x, int y) {
		System.out.println(x-y);
	}
}

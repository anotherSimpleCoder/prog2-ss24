package ex5;

public class Factorial implements MyFunction{

	@Override
	public int apply(int a) {
		int res = 1;
		for(int i = 0; i < a; i++) {
			res *= i;
		}
		
		return res;
	}

}

package ex5;

import java.util.function.IntPredicate;

public class Predicates {
	IntPredicate odd = new IntPredicate() {
		@Override
		public boolean test(int value) {
			return value % 2 != 0;
		}
	};
	
	IntPredicate even = (int value) -> value % 2 == 0;
	
	class InnerFactorial implements MyFunction {

		@Override
		public int apply(int a) {
			int res = 1;
			for(int i = 0; i < a; i++) {
				res *= i;
			}
			
			return res;
		}
	}
	
	public void applyAndPrint(int i, int j, MyFunction f) {
		for(int k = i; k <= j; k++) {
			int res = f.apply(k);
			System.out.println(res);
		}
	}
	
	public void functions() {
		final int x = 1;
		final int y = 10;
		
		//i) f(x) = x^2
		this.applyAndPrint(x, y, (a)-> a*a);
		
		//ii) f(x) = x! (lambda)
		this.applyAndPrint(x, y, (a)-> {
			int res = 1;
			for(int i = 0; i < a; i++) {
				res *= i;
			}
			
			return res;
		});
		
		//ii) (inner class)
		this.applyAndPrint(x, y, new InnerFactorial());
		
		//ii) (top-level class)
		this.applyAndPrint(x, y, new Factorial());
		
		//iii) f(x) = x^(x+1)
		this.applyAndPrint(x, y, (int a) -> (int)(Math.pow(a, a+1)));
		
		//iv) f(x) = fib(x)
		this.applyAndPrint(x, y, (int a) -> {
			int[] init = {1,1};
			for(int i = 0; i < a; i++) {
				int tmp = init[0];
				init[0] = init[1];
				init[1] = tmp + init[1];
			}
			
			return init[1];
		});
	}

	public void printEvenSquares() {
		final int x = 1;
		final int y = 10;
		
		this.applyAndPrint(x, y, (int a) -> {
			AdvancedFunction function = (int b)-> b*b;
			
			return function.conditionateInput(even).apply(a);
		});
	}
	
	public void printUnevenFactorial() {
		final int x = 1;
		final int y = 10;
		
		this.applyAndPrint(0, 0, (int a)-> {
			AdvancedFunction function = (b)-> {
				int res = 1;
				for(int i = 0; i < b; i++) {
					res *= i;
				}
				
				return res;
			};
			
			return function.conditionateOutput(odd).apply(a);
		});
	}
}

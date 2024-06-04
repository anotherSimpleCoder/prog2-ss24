package ex5;

import java.util.function.IntPredicate;

public interface AdvancedFunction extends MyFunction {
	default AdvancedFunction conditionateInput(IntPredicate predicate) {
		return (int x)-> {
			if(predicate.test(x)) {
				return apply(x);
			}
			
			return 0;
		};
	}
	
	default AdvancedFunction conditionateOutput(IntPredicate predicate) {
		return (int x)-> {
			int res = apply(x);
			
			if(predicate.test(res)) {
				return res;
			}
			
			return 0;
		};
	}
}

package pl.sda.zadania.fibonacci;

import java.math.BigDecimal;

public interface Fibonacci {

	public enum FibonacciType {
		RECURSIVE, ITERATIONAL;
	}

	BigDecimal getNValue(int n);

}

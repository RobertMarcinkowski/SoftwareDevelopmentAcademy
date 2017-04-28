package pl.sda.zadania.fibonacci.impl;

import java.math.BigDecimal;

import pl.sda.zadania.fibonacci.Fibonacci;

public class FibonacciRecursive implements Fibonacci {

	@Override
	public BigDecimal getNValue(int n) {
		if (n == 0) {
			return new BigDecimal(0);
		} else if (n == 1) {
			return new BigDecimal(1);
		} else {
			return getNValue(n - 1).add(getNValue(n - 2));
		}
	}

}

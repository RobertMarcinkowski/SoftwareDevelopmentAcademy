package pl.sda.zadania.factorial.impl;

import java.math.BigDecimal;

import pl.sda.zadania.factorial.Factorial;

public class FactorialRecursive implements Factorial {

	@Override
	public BigDecimal getN(int n) {
		if (n <= 0) {
			return new BigDecimal(1);
		}
		return getN(n - 1).multiply(new BigDecimal(n));
	}

}

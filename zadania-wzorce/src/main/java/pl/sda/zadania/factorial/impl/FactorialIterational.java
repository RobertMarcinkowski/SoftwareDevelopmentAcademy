package pl.sda.zadania.factorial.impl;

import java.math.BigDecimal;

import pl.sda.zadania.factorial.Factorial;

public class FactorialIterational implements Factorial {

	@Override
	public BigDecimal getN(int n) {
		if (n <= 0) {
			return new BigDecimal(1);
		}
		BigDecimal ret = new BigDecimal(1);
		for (int i = 1; i <= n; i++) {
			ret = ret.multiply(new BigDecimal(i));
		}
		return ret;
	}

}

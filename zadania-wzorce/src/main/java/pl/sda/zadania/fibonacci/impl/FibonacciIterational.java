package pl.sda.zadania.fibonacci.impl;

import java.math.BigDecimal;

import pl.sda.zadania.fibonacci.Fibonacci;

public class FibonacciIterational implements Fibonacci {

	@Override
	public BigDecimal getNValue(int n) {
		BigDecimal currentValue = new BigDecimal(0);
		if (n == 1) {
			currentValue = new BigDecimal(1);
		} else if (n > 1) {
			currentValue = new BigDecimal(1);
			BigDecimal prevValue = new BigDecimal(1);
			for (int i = 2; i < n; i++) {
				BigDecimal tempValue = currentValue;
				currentValue = currentValue.add(prevValue);
				prevValue = tempValue;
			}
		}
		return currentValue;
	}

}

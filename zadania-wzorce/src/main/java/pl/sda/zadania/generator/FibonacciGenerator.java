package pl.sda.zadania.generator;

import java.math.BigDecimal;

public class FibonacciGenerator {
	BigDecimal prev = new BigDecimal(0);
	BigDecimal current = new BigDecimal(1);

	public BigDecimal next() {
		BigDecimal tmp = current;
		current = current.add(prev);
		prev = tmp;
		return current;
	}

}

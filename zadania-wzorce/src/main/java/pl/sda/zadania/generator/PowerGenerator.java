package pl.sda.zadania.generator;

import java.math.BigDecimal;

public class PowerGenerator {
	BigDecimal current = new BigDecimal(1);
	int n;

	public PowerGenerator(int n) {
		this.n = n;
	}

	public BigDecimal next() {
		current = current.multiply(new BigDecimal(n));
		return current;
	}

}

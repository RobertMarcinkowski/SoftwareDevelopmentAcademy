package pl.sda.zadania.factorial;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import pl.sda.zadania.factorial.impl.FactorialIterational;
import pl.sda.zadania.factorial.impl.FactorialRecursive;

public class FactorialTest {
	@Test
	public void test() {
		Factorial factorialRecursive = new FactorialRecursive();
		Assert.assertEquals(new BigDecimal(24), factorialRecursive.getN(4));

		Factorial factorialIterational = new FactorialIterational();
		Assert.assertEquals(new BigDecimal(24), factorialIterational.getN(4));

	}

}

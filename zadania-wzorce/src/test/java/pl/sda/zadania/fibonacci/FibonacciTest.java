package pl.sda.zadania.fibonacci;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import pl.sda.zadania.fibonacci.Fibonacci.FibonacciType;
import pl.sda.zadania.fibonacci.factory.FibonacciFactory;

public class FibonacciTest {

	@Test
	public void test() {

		Fibonacci fibonacciRecursive = FibonacciFactory.getInstance().produce(FibonacciType.RECURSIVE);
		Fibonacci fibonacciIterational = FibonacciFactory.getInstance().produce(FibonacciType.ITERATIONAL);

		Assert.assertEquals(new BigDecimal(13), fibonacciRecursive.getNValue(7));
		Assert.assertEquals(new BigDecimal(13), fibonacciIterational.getNValue(7));

	}

}

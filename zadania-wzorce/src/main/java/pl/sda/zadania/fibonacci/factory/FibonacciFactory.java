package pl.sda.zadania.fibonacci.factory;

import pl.sda.zadania.fibonacci.Fibonacci;
import pl.sda.zadania.fibonacci.Fibonacci.FibonacciType;
import pl.sda.zadania.fibonacci.impl.FibonacciIterational;
import pl.sda.zadania.fibonacci.impl.FibonacciRecursive;

public class FibonacciFactory {

	private static FibonacciFactory instance;

	private FibonacciFactory() {

	}

	public synchronized static FibonacciFactory getInstance() {
		if (instance == null) {
			instance = new FibonacciFactory();
		}
		return instance;
	}

	public Fibonacci produce(FibonacciType type) {
		Fibonacci result = null;
		if (FibonacciType.ITERATIONAL.equals(type)) {
			result = new FibonacciIterational();
		}
		if (FibonacciType.RECURSIVE.equals(type)) {
			result = new FibonacciRecursive();
		}
		return result;
	}

}

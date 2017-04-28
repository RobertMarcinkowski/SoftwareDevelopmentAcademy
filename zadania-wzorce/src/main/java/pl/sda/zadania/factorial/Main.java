package pl.sda.zadania.factorial;

import pl.sda.zadania.factorial.impl.FactorialIterational;
import pl.sda.zadania.factorial.impl.FactorialRecursive;

public class Main {
	public static void main(String[] args) {
		Factorial factorialRecursive = new FactorialRecursive();
		System.out.println(factorialRecursive.getN(4));

		Factorial factorialIterational = new FactorialIterational();
		System.out.println(factorialIterational.getN(4));
	}

}

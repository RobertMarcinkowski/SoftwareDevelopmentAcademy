package pl.sda.zadania.fibonacci;

import pl.sda.zadania.fibonacci.Fibonacci.FibonacciType;
import pl.sda.zadania.fibonacci.factory.FibonacciFactory;
import pl.sda.zadania.fibonacci.impl.FibonacciIterational;
import pl.sda.zadania.fibonacci.impl.FibonacciRecursive;

public class Main {

	public static void main(String[] args) {
		Fibonacci fi = new FibonacciIterational();
		System.out.println(fi.getNValue(7));
		Fibonacci fr = new FibonacciRecursive();
		System.out.println(fr.getNValue(7));
		
		Fibonacci fibonacciRecursive = FibonacciFactory.getInstance().produce(FibonacciType.RECURSIVE);
		Fibonacci fibonacciIterational = FibonacciFactory.getInstance().produce(FibonacciType.ITERATIONAL);
		
		System.out.println("7 wyraz ciagu Fibonacciego obliczony rekurencyjnie: " + fibonacciRecursive.getNValue(7));
		System.out.println("7 wyraz ciagu Fibonacciego obliczony iteracyjnie: " + fibonacciIterational.getNValue(7));

	}

}

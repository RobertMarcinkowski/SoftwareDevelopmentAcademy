package pl.sda.zadania.adapter;

import java.util.ArrayList;
import java.util.List;

import pl.sda.zadania.fibonacci.Fibonacci;
import pl.sda.zadania.fibonacci.Fibonacci.FibonacciType;
import pl.sda.zadania.fibonacci.factory.FibonacciFactory;

public class Main {

	public static void main(String[] args) {
		Fibonacci fibonacciRecursive = FibonacciFactory.getInstance().produce(FibonacciType.RECURSIVE);
		FibonacciToSortAdapter fibonacciToSortAdapter = new FibonacciToSortAdapter(fibonacciRecursive);
		List<Integer> listToSort = new ArrayList<>();
		listToSort.add(7);
		List<Integer> sortedList = fibonacciToSortAdapter.sort(listToSort);
		for (Integer integer : sortedList) {
			System.out.println(integer);
		}
	}

}

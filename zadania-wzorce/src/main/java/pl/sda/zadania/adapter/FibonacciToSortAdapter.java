package pl.sda.zadania.adapter;

import java.util.ArrayList;
import java.util.List;

import pl.sda.zadania.fibonacci.Fibonacci;
import pl.sda.zadania.sort.Sort;

public class FibonacciToSortAdapter implements Sort {

	private Fibonacci fibonacci;

	public FibonacciToSortAdapter(Fibonacci fibonacci) {
		this.fibonacci = fibonacci;
	}

	@Override
	public List<Integer> sort(List<Integer> listToSort) {
		List<Integer> returnList = new ArrayList<>();
		returnList.add(fibonacci.getNValue(listToSort.get(0)).intValue());
		return returnList;
	}

}

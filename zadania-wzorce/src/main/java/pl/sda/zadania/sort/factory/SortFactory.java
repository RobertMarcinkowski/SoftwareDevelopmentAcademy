package pl.sda.zadania.sort.factory;

import pl.sda.zadania.sort.Sort;
import pl.sda.zadania.sort.Sort.SortType;
import pl.sda.zadania.sort.impl.BubbleSort;
import pl.sda.zadania.sort.impl.CountSort;

public class SortFactory {

	private static SortFactory instance;

	private SortFactory() {

	}

	public synchronized static SortFactory getInstance() {
		if (instance == null) {
			instance = new SortFactory();
		}
		return instance;
	}

	public Sort produce(SortType type) {
		Sort result = null;
		if (SortType.COUNT.equals(type)) {
			result = new CountSort();
		}
		if (SortType.BUBBLE.equals(type)) {
			result = new BubbleSort();
		}
		return result;
	}

}

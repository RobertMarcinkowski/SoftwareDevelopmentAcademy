package pl.sda.zadania.sort.impl;

import java.util.List;

import pl.sda.zadania.sort.Sort;

public class BubbleSort implements Sort {

	@Override
	public List<Integer> sort(List<Integer> listToSort) {
		for (int i = 0; i < listToSort.size(); i++) {
			for (int j = 0; j < listToSort.size() - i; j++) {
				if (j < listToSort.size() - 1 && listToSort.get(j) > listToSort.get(j + 1)) {
					swapListValues(listToSort, j, j + 1);
				}
			}
		}
		return listToSort;
	}

	private void swapListValues(List<Integer> listToSort, int indexA, int indexB) {
		Integer temp = listToSort.get(indexA);
		listToSort.set(indexA, listToSort.get(indexB));
		listToSort.set(indexB, temp);
	}

}

package pl.sda.zadania.sort.impl;

import java.util.ArrayList;
import java.util.List;

import pl.sda.zadania.sort.Sort;

public class CountSort implements Sort {

	@Override
	public List<Integer> sort(List<Integer> listToSort) {

		int maxValue = 0;
		for (Integer value : listToSort) {
			if (value > maxValue) {
				maxValue = value;
			}
		}

		if (maxValue > 0) {
			List<Integer> counts = new ArrayList<>();
			for (int i = 0; i < maxValue + 1; i++) {
				counts.add(0);
			}

			for (Integer value : listToSort) {
				// counts[value]++;
				counts.set(value, counts.get(value) + 1);
			}

			List<Integer> resultArray = new ArrayList<>();
			for (int index = 0; index < counts.size(); index++) {
				if (counts.get(index) > 0) {
					for (int i = 0; i < counts.get(index); i++) {
						resultArray.add(index);
					}
				}
			}

			listToSort = resultArray;

		}

		return listToSort;
	}

}

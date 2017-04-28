package pl.sda.zadania.sort;

import java.util.ArrayList;
import java.util.List;

import pl.sda.zadania.sort.Sort.SortType;
import pl.sda.zadania.sort.factory.SortFactory;
import pl.sda.zadania.sort.impl.BubbleSort;
import pl.sda.zadania.sort.impl.CountSort;

public class Main {

	public static void main(String[] args) {
		Sort bs = new BubbleSort();
		List<Integer> listToSort = new ArrayList<>();
		listToSort.add(6);
		listToSort.add(2);
		listToSort.add(1);
		listToSort.add(3);
		listToSort.add(4);
		listToSort.add(0);
		listToSort.add(1);
		List<Integer> listSortedBs = bs.sort(listToSort);
		for (Integer i : listSortedBs) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		Sort Cs = new CountSort();
		List<Integer> listSortedCs = Cs.sort(listToSort);
		for (Integer i : listSortedCs) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		Sort bubbleSort = SortFactory.getInstance().produce(SortType.BUBBLE);
		Sort countSort = SortFactory.getInstance().produce(SortType.COUNT);
		List<Integer> listSortedBubbleSort = bubbleSort.sort(listToSort);
		for (Integer i : listSortedBubbleSort) {
			System.out.print(i + ", ");
		}
		System.out.println("");
		List<Integer> listSortedCountSort = countSort.sort(listToSort);
		for (Integer i : listSortedCountSort) {
			System.out.print(i + ", ");
		}
		System.out.println("");

	}

}

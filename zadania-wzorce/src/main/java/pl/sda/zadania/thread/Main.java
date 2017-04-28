package pl.sda.zadania.thread;

import java.util.ArrayList;
import java.util.List;

import pl.sda.zadania.sort.Sort.SortType;

public class Main {

	public static void main(String[] args) {

		List<Integer> listToSort = new ArrayList<>();
		listToSort.add(6);
		listToSort.add(2);
		listToSort.add(1);
		listToSort.add(3);
		listToSort.add(4);
		listToSort.add(0);
		listToSort.add(1);

		Runnable thread1 = new SortThread(SortType.BUBBLE, listToSort, 1);
		Runnable thread2 = new SortThread(SortType.COUNT, listToSort, 2);
		Runnable thread3 = new SortThread(SortType.BUBBLE, listToSort, 3);

		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();

	}

}

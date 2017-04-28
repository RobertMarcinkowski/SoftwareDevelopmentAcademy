package pl.sda.zadania.thread;

import java.util.List;

import pl.sda.zadania.sort.Sort;
import pl.sda.zadania.sort.Sort.SortType;
import pl.sda.zadania.sort.factory.SortFactory;

public class SortThread implements Runnable {

	Sort sort;
	List<Integer> list;
	int threadNo;

	public SortThread(SortType sortType, List<Integer> listToSort, int threadNo) {
		sort = SortFactory.getInstance().produce(sortType);
		list = listToSort;
		this.threadNo = threadNo;
	}

	@Override
	public void run() {
		List<Integer> sortedList = sort.sort(list);
		for (Integer integer : sortedList) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread No: " + threadNo + "=> " + integer);
		}

	}

}

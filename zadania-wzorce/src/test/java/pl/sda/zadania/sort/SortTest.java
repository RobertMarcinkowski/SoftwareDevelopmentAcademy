package pl.sda.zadania.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import pl.sda.zadania.sort.Sort.SortType;
import pl.sda.zadania.sort.factory.SortFactory;

public class SortTest {

	@Test
	public void test() {
		List<Integer> listToSort = new ArrayList<>();
		listToSort.add(6);
		listToSort.add(2);
		listToSort.add(1);
		listToSort.add(3);
		listToSort.add(4);
		listToSort.add(0);
		listToSort.add(1);

		List<Integer> listSorted = new ArrayList<>();
		listSorted.add(0);
		listSorted.add(1);
		listSorted.add(1);
		listSorted.add(2);
		listSorted.add(3);
		listSorted.add(4);
		listSorted.add(6);

		Sort bubbleSort = SortFactory.getInstance().produce(SortType.BUBBLE);
		Sort countSort = SortFactory.getInstance().produce(SortType.COUNT);
		List<Integer> listSortedBubbleSort = bubbleSort.sort(listToSort);
		List<Integer> listSortedCountSort = countSort.sort(listToSort);

		Assert.assertEquals(listSorted, listSortedBubbleSort);
		Assert.assertEquals(listSorted, listSortedCountSort);

	}

}

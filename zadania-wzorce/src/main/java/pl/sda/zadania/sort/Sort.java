package pl.sda.zadania.sort;

import java.util.List;

public interface Sort {

	public enum SortType {
		COUNT, BUBBLE;
	}

	public List<Integer> sort(List<Integer> listToSort);

}

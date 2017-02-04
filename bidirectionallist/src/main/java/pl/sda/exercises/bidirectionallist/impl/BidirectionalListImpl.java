package pl.sda.exercises.bidirectionallist.impl;

import java.util.ArrayList;
import java.util.List;

import pl.sda.exercises.bidirectionallist.BidirectionalList;

public class BidirectionalListImpl<T> implements BidirectionalList<T> {
	private List<T> list;
	private int index;
	
	public BidirectionalListImpl() {
		this.list = new ArrayList<>();
		this.index = 0;
	}

	@Override
	public void push(T element) {
		index = 0;
		list.add(element);
	}

	@Override
	public T pop() {
		index = 0;
		return list.remove(list.size());
	}

	@Override
	public T readElement() {
		return list.get(index);
	}

	@Override
	public void printCollection() {
		int i = 1;
		for (T t : list) {
			System.out.println("Element nr: " + i + " - " + t);
			i++;
		}
	}

	@Override
	public T nextElement() {
		if (index + 1 < list.size()) {
			index++;
		} else {
			index = 0;
		}
		return list.get(index);
	}

	@Override
	public T previousElement() {
		if (index - 1 >= 0) {
			index--;
		} else {
			index = list.size() - 1;
		}
		return list.get(index);
	}

}

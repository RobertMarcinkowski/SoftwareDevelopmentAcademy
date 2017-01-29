package pl.sda.exercises.bidirectionallist;

import java.util.LinkedList;
import java.util.ListIterator;

public class BidirectionalList<T> {
	LinkedList<T> list = new LinkedList<>();
	ListIterator<T> iterator = list.listIterator();
	T element;

	public void push(T element) {
		list.add(element);
		iterator = list.listIterator();
		this.element = element;
	}

	public T pop() {
		T removedElement = list.remove();
		this.element = list.peek();
		iterator = list.listIterator();
		return removedElement;
	}

	public T readElement() {
		return element;
	}

	public void printCollection() {
		int i = 1;
		for (T t : list) {
			System.out.println("Element nr: " + i + " - " + t);
			i++;
		}
	}

	public T nextElement() {
		if (iterator.hasNext()) {
			this.element = iterator.next();
		} else {
			iterator = list.listIterator();
			this.element = iterator.next();
		}
		return element;
	}

	public T previousElement() {
		if (iterator.hasPrevious()) {
			this.element = iterator.previous();
		} else {
			iterator = list.listIterator(list.size());
			this.element = iterator.previous();
		}
		return element;
	}

}

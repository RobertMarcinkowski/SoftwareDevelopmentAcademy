package pl.sda.exercies.queues.impl;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import pl.sda.exercies.queues.Queues;

public class Lifo<T> implements Queues<T> {

	Deque<T> stack = new LinkedList<>();

	@Override
	public void push(T element) {
		stack.push(element);
	}

	@Override
	public T pop() {
		return stack.pop();
	}

	@Override
	public void printCollection() {
		int i = 1;
		for (Iterator<T> it = stack.descendingIterator(); it.hasNext();) {
			System.out.println("Element nr: " + i + " - " + it.next());
			i++;
		}
	}

}

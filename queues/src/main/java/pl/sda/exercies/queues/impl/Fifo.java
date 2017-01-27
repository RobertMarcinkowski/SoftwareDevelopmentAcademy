package pl.sda.exercies.queues.impl;

import java.util.LinkedList;
import java.util.Queue;

import pl.sda.exercies.queues.Queues;

public class Fifo<T> implements Queues<T> {

	Queue<T> queue = new LinkedList<>();

	@Override
	public void push(T element) {
		queue.add(element);
	}

	@Override
	public T pop() {
		return queue.remove();
	}

	@Override
	public void printCollection() {
		int i = 1;
		for (T t : queue) {
			System.out.println("Element nr: " + i + " - " + t);
			i++;
		}
	}

}

package pl.sda.exercies.queues.impl;

import java.util.Deque;
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

}

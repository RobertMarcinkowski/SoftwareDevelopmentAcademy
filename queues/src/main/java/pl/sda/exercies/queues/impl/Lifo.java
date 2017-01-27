package pl.sda.exercies.queues.impl;

import java.util.Deque;
import java.util.LinkedList;

import pl.sda.exercies.queues.Queues;

public class Lifo implements Queues {
	
	Deque<String> stack = new LinkedList<>();

	@Override
	public void push(String element) {
		stack.push(element);

	}

	@Override
	public String pop() {
		return stack.pop();
	}

}

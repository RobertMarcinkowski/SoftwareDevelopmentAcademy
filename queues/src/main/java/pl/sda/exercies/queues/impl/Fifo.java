package pl.sda.exercies.queues.impl;

import java.util.LinkedList;
import java.util.Queue;

import pl.sda.exercies.queues.Queues;

public class Fifo implements Queues {
	
	Queue<String> queue = new LinkedList<>();

	@Override
	public void push(String element) {
		queue.add(element);
	}

	@Override
	public String pop() {
		return queue.remove();
	}

}

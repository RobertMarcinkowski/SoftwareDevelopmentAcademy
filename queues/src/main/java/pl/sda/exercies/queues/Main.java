package pl.sda.exercies.queues;

import pl.sda.exercies.queues.impl.Fifo;
import pl.sda.exercies.queues.impl.Lifo;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("---FIFO---");
		Queues fifo = new Fifo();
		fifo.push("a");
		fifo.push("b");
		fifo.push("c");
		fifo.push("d");
		fifo.push("e");
		
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());
		
		System.out.println("---LIFO---");
		
		Queues lifo = new Lifo();
		lifo.push("a");
		lifo.push("b");
		lifo.push("c");
		lifo.push("d");
		lifo.push("e");
		
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());

	}

}

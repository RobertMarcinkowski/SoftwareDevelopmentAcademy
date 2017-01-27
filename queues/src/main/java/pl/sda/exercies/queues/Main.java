package pl.sda.exercies.queues;

import pl.sda.exercies.queues.impl.Fifo;
import pl.sda.exercies.queues.impl.Lifo;

public class Main {

	public static void main(String[] args) {

		System.out.println("---String---");
		System.out.println("---FIFO---");
		Queues<String> fifo = new Fifo<>();
		fifo.push("a");
		fifo.push("b");
		fifo.push("c");
		fifo.push("d");
		fifo.push("e");

		fifo.printCollection();

		System.out.println("---POP---");
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());
		System.out.println(fifo.pop());

		System.out.println("---LIFO---");
		Queues<String> lifo = new Lifo<>();
		lifo.push("a");
		lifo.push("b");
		lifo.push("c");
		lifo.push("d");
		lifo.push("e");

		lifo.printCollection();

		System.out.println("---POP---");
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());
		System.out.println(lifo.pop());

		System.out.println("---Integer---");
		System.out.println("---FIFO---");
		Queues<Integer> ififo = new Fifo<>();
		ififo.push(1);
		ififo.push(2);
		ififo.push(3);
		ififo.push(4);
		ififo.push(5);

		ififo.printCollection();

		System.out.println("---POP---");
		System.out.println(ififo.pop());
		System.out.println(ififo.pop());
		System.out.println(ififo.pop());
		System.out.println(ififo.pop());
		System.out.println(ififo.pop());

		System.out.println("---LIFO---");
		Queues<Integer> ilifo = new Lifo<>();
		ilifo.push(1);
		ilifo.push(2);
		ilifo.push(3);
		ilifo.push(4);
		ilifo.push(5);

		ilifo.printCollection();

		System.out.println("---POP---");
		System.out.println(ilifo.pop());
		System.out.println(ilifo.pop());
		System.out.println(ilifo.pop());
		System.out.println(ilifo.pop());
		System.out.println(ilifo.pop());

	}

}

package pl.sda.exercies.queues;

import org.junit.Assert;
import org.junit.Test;

import pl.sda.exercies.queues.impl.Fifo;
import pl.sda.exercies.queues.impl.Lifo;

public class QueuesTest {
	@Test
	public void StringTest() {
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
		Assert.assertEquals("a", fifo.pop());
		Assert.assertEquals("b", fifo.pop());
		Assert.assertEquals("c", fifo.pop());
		Assert.assertEquals("d", fifo.pop());
		Assert.assertEquals("e", fifo.pop());

		System.out.println("---LIFO---");
		Queues<String> lifo = new Lifo<>();
		lifo.push("a");
		lifo.push("b");
		lifo.push("c");
		lifo.push("d");
		lifo.push("e");

		lifo.printCollection();

		System.out.println("---POP---");
		Assert.assertEquals("e", lifo.pop());
		Assert.assertEquals("d", lifo.pop());
		Assert.assertEquals("c", lifo.pop());
		Assert.assertEquals("b", lifo.pop());
		Assert.assertEquals("a", lifo.pop());
	}

	@Test
	public void IntegerTest() {
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
		Assert.assertEquals(Integer.valueOf(1), ififo.pop());
		Assert.assertEquals(Integer.valueOf(2), ififo.pop());
		Assert.assertEquals(Integer.valueOf(3), ififo.pop());
		Assert.assertEquals(Integer.valueOf(4), ififo.pop());
		Assert.assertEquals(Integer.valueOf(5), ififo.pop());

		System.out.println("---LIFO---");
		Queues<Integer> ilifo = new Lifo<>();
		ilifo.push(1);
		ilifo.push(2);
		ilifo.push(3);
		ilifo.push(4);
		ilifo.push(5);

		ilifo.printCollection();

		System.out.println("---POP---");
		Assert.assertEquals(Integer.valueOf(5), ilifo.pop());
		Assert.assertEquals(Integer.valueOf(4), ilifo.pop());
		Assert.assertEquals(Integer.valueOf(3), ilifo.pop());
		Assert.assertEquals(Integer.valueOf(2), ilifo.pop());
		Assert.assertEquals(Integer.valueOf(1), ilifo.pop());
	}

}

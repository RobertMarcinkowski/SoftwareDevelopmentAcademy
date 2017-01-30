package pl.sda.exercises.bidirectionallist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.sda.exercises.bidirectionallist.impl.BidirectionalListImpl;

public class BidirectionalListTest {

	private BidirectionalListImpl<Integer> bl;

	@Before
	public void setUp() {
		bl = new BidirectionalListImpl<>();
		bl.push(1);
		bl.push(2);
		bl.push(3);
		bl.push(4);
		bl.push(5);
	}

	@Test
	public void test() {
		Assert.assertEquals(Integer.valueOf(1), bl.readElement());

		Assert.assertEquals(Integer.valueOf(2), bl.nextElement());
		Assert.assertEquals(Integer.valueOf(2), bl.readElement());

		Assert.assertEquals(Integer.valueOf(3), bl.nextElement());
		Assert.assertEquals(Integer.valueOf(4), bl.nextElement());
		Assert.assertEquals(Integer.valueOf(5), bl.nextElement());
		Assert.assertEquals(Integer.valueOf(1), bl.nextElement());
		Assert.assertEquals(Integer.valueOf(2), bl.nextElement());
		Assert.assertEquals(Integer.valueOf(3), bl.nextElement());

		Assert.assertEquals(Integer.valueOf(3), bl.readElement());

		Assert.assertEquals(Integer.valueOf(2), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(2), bl.readElement());

		Assert.assertEquals(Integer.valueOf(1), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(5), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(4), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(3), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(2), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(1), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(5), bl.previousElement());
		Assert.assertEquals(Integer.valueOf(4), bl.previousElement());

		Assert.assertEquals(Integer.valueOf(4), bl.readElement());

	}
}

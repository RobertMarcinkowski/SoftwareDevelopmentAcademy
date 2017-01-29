package pl.sda.exercises.bidirectionallist.impl;

public class Main {

	public static void main(String[] args) {
		BidirectionalListImpl<Integer> bl = new BidirectionalListImpl<>();
		bl.push(1);
		bl.push(2);
		bl.push(3);
		bl.push(4);
		bl.push(5);

		bl.printCollection();
		System.out.println(bl.readElement());
		System.out.println(bl.nextElement());
		System.out.println(bl.nextElement());
		System.out.println(bl.previousElement());
		System.out.println(bl.previousElement());

	}

}

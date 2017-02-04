package pl.sda.exercises.bidirectionallist;

import pl.sda.exercises.bidirectionallist.impl.BidirectionalListImpl;

public class Main {

	public static void main(String[] args) {
		BidirectionalList<Integer> bidirectionalList = new BidirectionalListImpl<>();
		bidirectionalList.push(1);
		bidirectionalList.push(2);
		bidirectionalList.push(3);
		bidirectionalList.push(4);
		bidirectionalList.push(5);

		bidirectionalList.printCollection();
		System.out.println(bidirectionalList.readElement());
		System.out.println(bidirectionalList.nextElement());
		System.out.println(bidirectionalList.nextElement());
		System.out.println(bidirectionalList.nextElement());
		System.out.println(bidirectionalList.nextElement());
		System.out.println(bidirectionalList.nextElement());
		System.out.println(bidirectionalList.nextElement());
		System.out.println(bidirectionalList.readElement());
		System.out.println(bidirectionalList.previousElement());
		System.out.println(bidirectionalList.previousElement());
		System.out.println(bidirectionalList.previousElement());
		System.out.println(bidirectionalList.previousElement());
		System.out.println(bidirectionalList.previousElement());
		System.out.println(bidirectionalList.previousElement());

	}

}

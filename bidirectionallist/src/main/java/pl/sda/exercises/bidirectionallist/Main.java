package pl.sda.exercises.bidirectionallist;

public class Main {

	public static void main(String[] args) {
		BidirectionalList<Integer> bl = new BidirectionalList<>();
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

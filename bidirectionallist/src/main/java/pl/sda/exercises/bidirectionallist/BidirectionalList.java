package pl.sda.exercises.bidirectionallist;

public interface BidirectionalList<T> {
	void push(T element);

	T pop();

	T readElement();

	void printCollection();

	T nextElement();

	T previousElement();
}

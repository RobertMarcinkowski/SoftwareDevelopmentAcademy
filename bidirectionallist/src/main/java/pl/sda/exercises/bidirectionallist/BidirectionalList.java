package pl.sda.exercises.bidirectionallist;

public interface BidirectionalList<T> {
	public void push(T element);

	public T pop();

	public T readElement();

	public void printCollection();

	public T nextElement();

	public T previousElement();
}

package pl.sda.exercies.queues;

public interface Queues<T> {
	
	void push(T element);
	
	T pop();

}

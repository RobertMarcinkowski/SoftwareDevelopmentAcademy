package pl.sda.zadania.generator;

public class Main {

	public static void main(String[] args) {
		FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();
		for (int i = 0; i < 10; i++) {
			System.out.println(fibonacciGenerator.next());
		}
		System.out.println("######################################");
		PowerGenerator powerGenerator = new PowerGenerator(3);
		for (int i = 0; i < 10; i++) {
			System.out.println(powerGenerator.next());
		}

	}

}

package pl.sda.exercises.hangman;

import java.util.Scanner;

public class HangmanUI {
	public void start() {
		System.out.println("GRA W WISIELCA");
		System.out.println("Nacisnij Enter by rozpoczac");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public void printStatus(Word word) {
		System.out.println(word);
	}

	public String getInput() {
		System.out.println("Podaj litere lub slowo");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while ((input.length() < 1)) {
			System.out.println("Podaj litere lub slowo ponownie");
			input = scanner.nextLine();
		}
		System.out.println("Wprowadziles: " + input);
		return input;
	}

	public void printWinGame(Word word) {

		System.out.println("GRATULACJE, to slowo to: " + word.getWord());
	}

	public void printLostGame(Word word) {

		System.out.println("Niestety, to slowo to: " + word.getWord());
	}
}

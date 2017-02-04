package pl.sda.exercises.hangman;

import java.util.Scanner;

public class HangmanUI {
	public void start() {
		System.out.println("HANGMAN GAME");
		System.out.println("Press ENTER to start");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public void printStatus(Word word) {
		System.out.println(word);
	}

	public String getInput() {
		System.out.println("Enter a letter or word");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (input.length() < 1) {
			System.out.println("Enter a letter or word again");
			input = scanner.nextLine();
		}
		System.out.println("You entered: " + input);
		return input;
	}

	public void characterAlreadyUsed() {
		System.out.println("Letter was already used");
	}

	public void noSuchCharacter() {
		System.out.println("There is no such letter in the word");
	}

	public void characterExists() {
		System.out.println("This letter exists in the word");
	}

	public void wrongWord() {
		System.out.println("It's not the word");
	}

	public void printWinGame(Word word) {

		System.out.println("CONGRATULATIONS, this word is: " + word.getWord());
	}

	public void printLostGame(Word word) {

		System.out.println("Unfortunately, it is the word: " + word.getWord());
	}
}

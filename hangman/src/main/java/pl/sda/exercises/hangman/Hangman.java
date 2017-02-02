package pl.sda.exercises.hangman;

import java.io.File;
import java.io.FileNotFoundException;

public class Hangman {

	public static final String WORDS_FILE_PATH = "hangmanwords.txt";

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(WORDS_FILE_PATH);
		HangmanUI ui = new HangmanUI();
		HangmanFileOperations fileOperations = new HangmanFileOperations();
		ui.start();
		Word randomWord = fileOperations.getRandomWord(file);

		ui.printStatus(randomWord);

		String input = ui.getInput();

		while (!input.startsWith(randomWord.getWord()) && randomWord.getAttempts() > 1) {
			if (input.length() == 1) {
				if (randomWord.getListUsedCharacters().contains(input.charAt(0))) {
					System.out.println("Znak byl juz wykorzystany");
					randomWord.decreaseAttempts();
				} else if (!randomWord.getWord().contains(input)) {
					System.out.println("Nie ma takiego znaku w tym slowie");
					randomWord.decreaseAttempts();
					randomWord.getListUsedCharacters().add(input.charAt(0));
				} else {
					randomWord.checkWord(input.charAt(0));
				}
			} else {
				System.out.println("To nie to slowo");
				randomWord.decreaseAttempts();
			}

			ui.printStatus(randomWord);
			input = ui.getInput();

		}
		if (input.startsWith(randomWord.getWord())) {
			ui.printWinGame(randomWord);
		} else {
			ui.printLostGame(randomWord);
		}

	}

}

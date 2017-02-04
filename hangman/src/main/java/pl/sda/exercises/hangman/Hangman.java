package pl.sda.exercises.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Hangman {

	public static final String WORDS_FILE_PATH = "hangmanwords.txt";

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(WORDS_FILE_PATH);
		HangmanUI ui = new HangmanUI();
		HangmanFileOperations fileOperations = new HangmanFileOperations();
		WordsHelper wordsHelper = new WordsHelper();
		ui.start();
		List<Word> wordsList = fileOperations.getListOfWords(file);
		Word randomWord = wordsHelper.getRandomWord(wordsList);

		ui.printStatus(randomWord);

		String input = ui.getInput();

		while (randomWord.continueGame(input)) {
			if (input.length() == 1) {
				if (randomWord.characterUsed(input)) {
					ui.characterAlreadyUsed();
					randomWord.decreaseAttempts();
				} else if (randomWord.noCharacterInWord(input)) {
					ui.noSuchCharacter();
					randomWord.decreaseAttempts();
					randomWord.addCharToList(input);
				} else {
					randomWord.indicateCharacter(input);
					ui.characterExists();
				}
			} else {
				ui.wrongWord();
				randomWord.decreaseAttempts();
			}

			ui.printStatus(randomWord);
			input = ui.getInput();

		}
		if (randomWord.wordGuessed(input)) {
			ui.printWinGame(randomWord);
		} else {
			ui.printLostGame(randomWord);
		}

	}

}

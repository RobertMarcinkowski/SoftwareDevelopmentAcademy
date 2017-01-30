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

	}

}

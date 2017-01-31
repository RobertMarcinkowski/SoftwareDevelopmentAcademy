package pl.sda.exercises.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanFileOperations {

	public List<Word> getListOfWords(File file) throws FileNotFoundException {
		List<Word> words = new ArrayList<>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			Word word = new Word();
			String line = scanner.nextLine();
			String[] split = line.split(" ");
			word.setWord(split[0]);
			word.setAttempts(Integer.valueOf(split[1]));
			words.add(word);
		}
		return words;
	}

	public Word getRandomWord(File file) throws FileNotFoundException {
		List<Word> words = getListOfWords(file);
		Random random = new Random();
		return words.get(random.nextInt(words.size()));
	}

}

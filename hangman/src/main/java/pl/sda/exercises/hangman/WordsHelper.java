package pl.sda.exercises.hangman;

import java.util.List;
import java.util.Random;

public class WordsHelper {
	
	public Word getRandomWord(List<Word> words) {
		Random random = new Random();
		int randomIndex = random.nextInt(words.size());
		return words.get(randomIndex);
	}

}

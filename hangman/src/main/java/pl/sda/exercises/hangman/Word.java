package pl.sda.exercises.hangman;

import java.util.ArrayList;
import java.util.List;

public class Word {
	private String word;
	private int attempts;
	private String status = "";
	private List<Character> listUsedCharacters = new ArrayList<>();

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
		for (int i = 0; i < word.length(); i++) {
			status += "_";
		}
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public void decreaseAttempts() {
		attempts--;
	}

	public void indicateCharacter(String input) {
		char character = input.charAt(0);
		for (int i = 0; i < word.length(); i++) {
			if (character == word.charAt(i)) {
				status = status.substring(0, i) + character + status.substring(i + 1);
			}
		}
		listUsedCharacters.add(Character.valueOf(character));
	}

	public boolean continueGame(String input) {
		return ((wordGuessed(word)) && chancesRemained());
	}

	public boolean wordGuessed(String input) {
		return input.startsWith(word);
	}

	public boolean chancesRemained() {
		return attempts > 1;
	}

	public boolean characterUsed(String input) {
		return listUsedCharacters.contains(input.charAt(0));
	}

	public boolean noCharacterInWord(String input) {
		return !word.contains(input);
	}

	public void addCharToList(String input) {
		listUsedCharacters.add(input.charAt(0));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Masz ").append(attempts).append(" prob - ");
		for (int i = 0; i < status.length(); i++) {
			if (i == status.length() - 1) {
				sb.append(status.charAt(i));
			} else {
				sb.append(status.charAt(i)).append(",");
			}
		}
		if (listUsedCharacters.size() > 0) {
			sb.append("\nWykorzystane znaki: ");
			for (Character character : listUsedCharacters) {
				sb.append(character).append(" ");
			}
		}
		return sb.toString();
	}

}

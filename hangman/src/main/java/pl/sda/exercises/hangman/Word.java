package pl.sda.exercises.hangman;

import java.util.ArrayList;
import java.util.List;

public class Word {
	private String word;
	private int attempts;
	private String status = "";
	private List<Character> listUsedCharacters = new ArrayList<>();

	public List<Character> getListUsedCharacters() {
		return listUsedCharacters;
	}

	public String getStatus() {
		return status;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
		for (int i = 0; i < word.length(); i++) {
			status += "_";
		}
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public void decreaseAttempts() {
		attempts--;
	}

	public void checkWord(char character) {
		for (int i = 0; i < word.length(); i++) {
			if (character == word.charAt(i)) {
				status = status.substring(0, i) + character + status.substring(i + 1);
				System.out.println(i + " " + status);
			}
		}
		listUsedCharacters.add(Character.valueOf(character));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(word).append(" - Masz ").append(attempts).append(" prob - ");
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

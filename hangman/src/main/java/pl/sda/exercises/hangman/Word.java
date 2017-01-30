package pl.sda.exercises.hangman;

public class Word {
	private String word;
	private int attempts;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	@Override
	public String toString() {
		return word + " - " + attempts;
	}

}

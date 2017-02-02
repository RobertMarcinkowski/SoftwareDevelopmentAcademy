package pl.sda.exercises.sudokusolver.fileoperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperations {
	public int[] readFromFile(File file) throws FileNotFoundException {
		int[] result = new int[81];
		Scanner scanner = new Scanner(file);
		int row = 0;
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			char[] array = line.toCharArray();
			for (int i = 0; i < array.length || i < 9; i++) {
				result[row * 9 + i] = Character.getNumericValue(array[i]);
			}
			row++;
		}
		return result;
	}

	public void writeToFile(File file, int[] sudoku) throws IOException {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
			for (int i = 0; i < sudoku.length; i++) {
				if (i % 9 == 8) {
					out.printf("%d\n", sudoku[i]);
				} else {
					out.printf("%d", sudoku[i]);
				}
			}
		}
	}
}

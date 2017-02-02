package pl.sda.exercises.sudokusolver;

import java.io.File;
import java.io.IOException;

import pl.sda.exercises.sudokusolver.fileoperations.FileOperations;
import pl.sda.exercises.sudokusolver.impl.SudokuBacktracking;

public class Main {

	public static final String SUDOKU_INPUT_PATH = "sudoku.txt";
	public static final String SUDOKU_OUTPUT_PATH = "result.txt";

	public static void main(String[] args) throws IOException {

		File input = new File(SUDOKU_INPUT_PATH);
		File output = new File(SUDOKU_OUTPUT_PATH);
		FileOperations fileOperations = new FileOperations();
		int[] sudoku = fileOperations.readFromFile(input);
		SudokuSolver solver = new SudokuBacktracking();
		System.out.println("INPUT");
		solver.printSudoku(sudoku);
		System.out.println("");
		int[] result = solver.solveSudoku(sudoku);
		System.out.println("OUTPUT");
		solver.printSudoku(result);
		fileOperations.writeToFile(output, result);

	}

}

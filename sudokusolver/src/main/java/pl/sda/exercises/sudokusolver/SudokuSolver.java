package pl.sda.exercises.sudokusolver;

public interface SudokuSolver {
	/**
	 * returns solved sudoku as array of int
	 * @param sudokuIn sudoku to be solved as array of int
	 * @return solved sudoku as array of int
	 */
	int[] solveSudoku(int[] sudokuIn);

	void printSudoku(int[] sudoku);
}

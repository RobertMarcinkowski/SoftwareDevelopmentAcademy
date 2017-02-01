package pl.sda.exercises.sudokusolver.impl;

import pl.sda.exercises.sudokusolver.SudokuSolver;

public class SudokuBacktracking implements SudokuSolver {

	private int[] sudoku;

	@Override
	public int[] solveSudoku(int[] sudokuIn) {
		sudoku = sudokuIn;
		if (solve(0)) {
			return sudoku;
		} else {
			return sudokuIn;
		}
	}

	private boolean solve(int index) {

		for (int i = index; i < sudoku.length; i++) {
			if (sudoku[i] > 0) {
				if (i == sudoku.length - 1) {
					return true;
				} else {
					continue;
				}
			} else {

				for (int n = 1; n < 10; n++) {
					if (possibleInsertion(i, n)) {
						sudoku[i] = n;
						if (solve(i + 1)) {
							return true;

						} else {
							sudoku[i] = 0;
						}
					}
				}
				return false;
			}
		}

		return false;
	}

	private boolean possibleInsertion(int i, int n) {

		for (int j = (i / 9) * 9; j < (((i / 9) * 9) + 9); j++) {
			if (sudoku[j] == n) {
				return false;
			}
		}
		for (int j = i % 9; j < sudoku.length; j = j + 9) {
			if (sudoku[j] == n) {
				return false;
			}
		}

		// TODO: add 3X3 check condition
		return true;
	}

	@Override
	public void printSudoku(int[] sudoku) {
		for (int i = 0; i < sudoku.length; i++) {

			if (i % 9 == 8) {
				System.out.printf("%d\n", sudoku[i]);
			} else {
				System.out.printf("%d,", sudoku[i]);
			}
		}

	}

}

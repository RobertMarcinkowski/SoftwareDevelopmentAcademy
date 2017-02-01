package pl.sda.exercises.sudokusolver;

import org.junit.Assert;
import org.junit.Test;

import pl.sda.exercises.sudokusolver.impl.SudokuBacktracking;

public class SudokuTests {
	
	@Test
	public void test1(){
		
		int[] sudoku = {3,0,5,0,9,0,0,0,0,
						0,6,0,0,0,4,0,5,0,
						0,0,0,0,0,8,3,0,0,
						6,0,0,0,0,2,0,0,0,
						0,0,2,9,0,5,1,0,0,
						0,0,0,4,0,0,0,0,6,
						0,0,4,2,0,0,0,0,0,
						0,2,0,3,0,0,0,7,0,
						0,0,0,0,1,0,4,0,5};
		
		for (int i = 0; i < sudoku.length; i++) {
			int x = i%9;
			int y = i/9;
			System.out.printf("(%d,%d)",x/3,y/3);
			if(x==8) System.out.printf("\n");
		}
		
		int[] sudokuSolved = {	3,4,5,6,9,1,7,8,2,
								2,6,8,7,3,4,9,5,1,
								7,1,9,5,2,8,3,6,4,
								6,9,3,1,7,2,5,4,8,
								4,8,2,9,6,5,1,3,7,
								1,5,7,4,8,3,2,9,6,
								8,7,4,2,5,9,6,1,3,
								5,2,1,3,4,6,8,7,9,
								9,3,6,8,1,7,4,2,5}; 
		
		SudokuSolver solver = new SudokuBacktracking();
		int[] result = solver.solveSudoku(sudoku);
		solver.printSudoku(result);
		Assert.assertArrayEquals(sudokuSolved, result);
		
	}

}

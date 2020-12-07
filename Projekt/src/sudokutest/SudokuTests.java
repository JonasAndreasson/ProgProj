package sudokutest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import sudoku.*;

class SudokuTests {

	SudokuSolver solver = new Solver();

	@Before
	public void setUp() {
		solver.removeNumber();
	}

	@Test
	public void solveEmpty() {
		assertTrue(solver.solve(), "Solver.solve() should return true, and be able to solve the empty grid");
	}

	@Test
	public void insert() {
		solver.setNumber(0, 0, 1);
		assertEquals(1, solver.getNumber(0, 0), "The number should be added");
	}

	@Test
	public void insertDuplicatest() {
		solver.setNumber(0, 0, 1);
		solver.setNumber(1, 1, 1);
		assertEquals(0, solver.getNumber(1, 1),
				"The cell should still be empty if trying to add another 1 in the same \" box \"");
	}

	@Test
	public void solveExample() {
		int[][] grid = new int[9][9];
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				grid[row][col] = 0;
			}
		}
		grid[2][0] = 1;
		grid[5][0] = 6;
		grid[6][0] = 4;
		grid[7][0] = 8;
		grid[4][1] = 5;
		grid[6][1] = 1;
		grid[7][1] = 6;
		grid[0][2] = 8;
		grid[2][2] = 2;
		grid[2][3] = 5;
		grid[3][3] = 2;
		grid[6][3] = 6;
		grid[3][4] = 1;
		grid[7][4] = 3;
		grid[0][5] = 9;
		grid[6][5] = 8;
		grid[4][6] = 6;
		grid[7][6] = 1;
		grid[8][6] = 4;
		grid[0][7] = 6;
		grid[3][7] = 9;
		grid[5][7] = 2;
		grid[0][8] = 2;
		grid[1][8] = 5;
		grid[5][8] = 8;
		solver.setNumbers(grid);
		assertEquals(0, solver.getNumber(0, 0), "The first position should still be empty");
		assertSame(solver.getNumbers(), grid, "The grid of the solver should be equal to the input grid");
		assertTrue(solver.solve());
	}

	@Test
	public void testImpossibleGrid() {
		int[][] grid = new int[9][9];
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				grid[row][col] = 0;
			}
		}
		grid[0][0] = 5;
		grid[0][1] = 1;
		grid[0][2] = 6;
		grid[0][3] = 8;
		grid[0][4] = 4;
		grid[0][5] = 9;
		grid[0][6] = 7;
		grid[0][7] = 3;
		grid[0][8] = 2;
		grid[1][0] = 3;
		grid[1][2] = 7;
		grid[1][3] = 6;
		grid[1][5] = 5;
		grid[2][0] = 8;
		grid[2][2] = 9;
		grid[2][3] = 7;
		grid[2][7] = 6;
		grid[2][8] = 5;
		grid[3][0] = 1;
		grid[3][1] = 3;
		grid[3][2] = 5;
		grid[3][4] = 6;
		grid[3][6] = 9;
		grid[3][8] = 7;
		grid[4][0] = 4;
		grid[4][1] = 7;
		grid[4][2] = 2;
		grid[4][3] = 5;
		grid[4][4] = 9;
		grid[4][5] = 1;
		grid[4][8] = 6;
		grid[5][0] = 9;
		grid[5][1] = 6;
		grid[5][2] = 8;
		grid[5][3] = 3;
		grid[5][4] = 7;
		grid[5][7] = 5;
		grid[6][0] = 2;
		grid[6][1] = 5;
		grid[6][2] = 3;
		grid[6][3] = 1;
		grid[6][4] = 8;
		grid[6][5] = 6;
		grid[6][7] = 7;
		grid[6][8] = 4;
		grid[7][0] = 6;
		grid[7][1] = 8;
		grid[7][2] = 4;
		grid[7][3] = 2;
		grid[7][5] = 7;
		grid[7][6] = 5;
		grid[8][0] = 7;
		grid[8][1] = 9;
		grid[8][2] = 1;
		grid[8][4] = 5;
		grid[8][6] = 6;
		grid[8][8] = 8;
		solver.setNumbers(grid);
		assertFalse(solver.solve(),"This is impossible to solve");

	}

}

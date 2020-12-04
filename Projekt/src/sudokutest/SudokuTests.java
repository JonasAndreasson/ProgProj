package sudokutest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import sudoku.Solver;

class SudokuTests {

	Solver solver = new Solver();

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
		solver.setNumber(2, 0, 1);
		solver.setNumber(5, 0, 6);
		solver.setNumber(6, 0, 4);
		solver.setNumber(7, 0, 8);
		solver.setNumber(4, 1, 5);
		solver.setNumber(6, 1, 1);
		solver.setNumber(7, 1, 6);
		solver.setNumber(0, 2, 8);
		solver.setNumber(2, 2, 2);
		solver.setNumber(2, 3, 5);
		solver.setNumber(3, 3, 2);
		solver.setNumber(6, 3, 6);
		solver.setNumber(3, 4, 1);
		solver.setNumber(7, 4, 3);
		solver.setNumber(0, 5, 9);
		solver.setNumber(6, 5, 8);
		solver.setNumber(4, 6, 6);
		solver.setNumber(7, 6, 1);
		solver.setNumber(8, 6, 4);
		solver.setNumber(0, 7, 6);
		solver.setNumber(3, 7, 9);
		solver.setNumber(5, 7, 2);
		solver.setNumber(0, 8, 2);
		solver.setNumber(1, 8, 5);
		solver.setNumber(5, 8, 8);
		long l = System.currentTimeMillis();
		assertTrue(solver.solve());
		long l2 = System.currentTimeMillis();
		System.out.println(l2-l);
	}

}

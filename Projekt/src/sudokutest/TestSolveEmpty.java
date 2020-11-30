package sudokutest;

import sudoku.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

class TestSolveEmpty {
	Solver solver = new Solver();
	@Before
	public void setUp() {
	solver.removeNumber();
	}

	@Test
	public void test() {
		assertTrue(solver.solve());
	}

}

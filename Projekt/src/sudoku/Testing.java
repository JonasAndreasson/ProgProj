package sudoku;

public class Testing {
	public static void main(String[] args) {
		Solver solver = new Solver();
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
		//test.clear();
		solver.solve();
		for (int i = 0; i < 9; i++) {
			String output = "";
			for (int j = 0; j < 9; j++) {
				output = output +" "+ Integer.toString(solver.getNumber(i, j));
			}
			System.out.println(output);
		}
		// System.out.println(test.solvedBox(0, 0));

	}
}

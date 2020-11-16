package sudoku;

public class Testing {
	public static void main(String[] args) {
		String[] rows = new String[9];
		Solver test = new Solver();
		test.setNumber(2, 0, 1);
		test.setNumber(5, 0, 6);
		test.setNumber(6, 0, 4);
		test.setNumber(7, 0, 8);
		test.setNumber(4, 1, 5);
		test.setNumber(6, 1, 1);
		test.setNumber(7, 1, 6);
		test.setNumber(0, 2, 8);
		test.setNumber(2, 2, 2);
		test.setNumber(2, 3, 5);
		test.setNumber(3, 3, 2);
		test.setNumber(6, 3, 6);
		test.setNumber(3, 4, 1);
		test.setNumber(7, 4, 3);
		test.setNumber(0, 5, 9);
		test.setNumber(6, 5, 8);
		test.setNumber(4, 6, 6);
		test.setNumber(7, 6, 1);
		test.setNumber(8, 6, 4);
		test.setNumber(0, 7, 6);
		test.setNumber(3, 7, 9);
		test.setNumber(5, 7, 2);
		test.setNumber(0, 8, 2);
		test.setNumber(1, 8, 5);
		test.setNumber(5, 8, 8);
		//test.clear();
		test.solve();
		for (int i = 0; i < 9; i++) {
			String output = "";
			for (int j = 0; j < 9; j++) {
				output = output +" "+ Integer.toString(test.getNumber(i, j));
			}
			System.out.println(output);
		}
		// System.out.println(test.solvedBox(0, 0));

	}
}

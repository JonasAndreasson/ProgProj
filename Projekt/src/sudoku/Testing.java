package sudoku;

public class Testing {
	public static void main(String[] args) {
		Solver test = new Solver();
		test.setNumber(0, 0, 1);
		test.setNumber(0, 1, 2);
		test.setNumber(0, 2, 3);
		test.setNumber(1, 0, 4);
		test.setNumber(1, 1, 5);
		test.setNumber(1, 2, 6);
		test.setNumber(2, 0, 7);
		test.setNumber(2, 1, 8);
		test.setNumber(2, 2, 9);
		//System.out.println(test.solvedBox(0, 0));
		
	}
}

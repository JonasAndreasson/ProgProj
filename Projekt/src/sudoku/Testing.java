package sudoku;

public class Testing {
	public static void main(String[] args) {
		String[]rows = new String[9];
		Solver test = new Solver();
		System.out.println(test.solve());
		for (int i = 0; i < 9; i++) {
			String output ="";
			for (int j = 0; j < 9; j++) {
				output = output + Integer.toString(test.getNumber(j, i));
			}
			System.out.println(output);
		}
		//System.out.println(test.solvedBox(0, 0));
		
	}
}

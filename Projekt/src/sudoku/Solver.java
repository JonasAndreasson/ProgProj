package sudoku;

import java.io.*;
import java.util.*;

public class Solver implements SudokuSolver {
	private int[][] grid;

	public Solver() {
		grid = new int[9][9];
		removeNumber();
	}

	public Solver(int[][] grid) {
		this.grid = grid;
	}

	@Override
	/**
	 * Removes all numbers from the board
	 */
	public void removeNumber() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = 0;
			}
		}

	}

	@Override
	/**
	 * Removes the number located on row row and column col
	 * 
	 * @param row  the row where the number is located
	 * @param col  the column where the number is located
	 * 
	 * @throws IllegalArgumentException if row or col is outside [0..8]
	 */
	public void removeNumber(int row, int col) {
		grid[row][col] = 0;
	}

	@Override
	/**
	 * Sets the digit number in the box row, col.
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert in row, col
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	public void setNumber(int row, int col, int number) {
		if (trySetNumber(row, col, number)) {

			grid[row][col] = number;

		}
	}

	@Override

	/**
	 * Returns the number in the row and in the column col
	 * 
	 * @param row the row where the number is located
	 * @param col the column where the number is located
	 * @return the number as an Integer
	 * 
	 * @throws IllegalArgumentException if row or col is outside [0..8]
	 */
	public int getNumber(int row, int col) {
		return grid[row][col];
	}

	@Override
	public boolean solve() {

		solveIt(0, 0);

		return isSolved();
	}

	private void solveIt(int row, int col) {
		boolean ourInput = false;
		if (col == 9) {
			return;
		}
		if (row == 9) {
			solveIt(0, col + 1);
			return;
		}
		if (isEmpty(row, col)) {
			if (tryPlacing(row, col)) {
				ourInput = true;
			} else {
				return;
			}

		}
		if (isSolved()) {
			return;
		}
		solveIt(row + 1, col);
		if (isSolved()) {
			return;
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (ourInput && tryPlacing(row, col, list)) {
			list.add(getNumber(row, col));
			solveIt(row + 1, col);
			if (isSolved()) {
				return;
			}
		}
		if (!isSolved() && ourInput) {
			removeNumber(row, col);
			return;
		}

	}

	private boolean tryPlacing(int row, int col, List<Integer> list) {
		for (int i = 1; i <= 9; i++) {
			if (trySetNumber(row, col, i) && !list.contains(i)) {
				setNumber(row, col, i);
				return true;
			}
		}

		return false;
	}

	private void solveRow(int row, int col) {
		boolean ourInput = false;
		if (solvedCol(col)) {
			return;
		}
		if (isEmpty(row, col)) {
			ourInput = true;
			tryPlacing(row, col);
			if (isEmpty(row, col)) {
				return;
			}
		}
		solveRow(row + 1, col);
		if (solvedCol(col)) {
			return;
		}
		int num = getNumber(row, col);
		if (ourInput)
			solve(row, col, num);
	}

	private void solve(int row, int col, int num) {
		if (tryPlacing(row, col, num)) {
			solveRow(row + 1, col);
		}
	}

	private boolean isEmpty(int row, int col) {
		return grid[row][col] == 0;
	}

	private boolean tryPlacing(int row, int col) {
		for (int i = 1; i < 10; i++) {
			if (trySetNumber(row, col, i)) {
				setNumber(row, col, i);
				return true;
			}
		}
		return false;
	}

	private boolean tryPlacing(int row, int col, int num) {
		for (int i = 1; i < 10; i++) {
			if (trySetNumber(row, col, i) && i != num) {
				setNumber(row, col, i);
				return true;
			}
		}
		return false;
	}

	private boolean isSolved() {
		for (int i = 0; i < 9; i++) {
			if (!solvedRow(i) || !solvedCol(i) || !solvedBox(i, i)) {
				return false;
			}
		}

		return true;
	}

	private boolean solvedRow(int row) {
		String output = "";
		String correct = "123456789";
		for (int i = 0; i < 9; i++) {
			output = output + Integer.toString(grid[row][i]);
		}
		output = sortString(output);
		return output.matches(correct);
	}

	private boolean solvedCol(int col) {
		String output = "";
		String correct = "123456789";
		for (int i = 0; i < 9; i++) {
			output = output + Integer.toString(grid[i][col]);
		}
		output = sortString(output);
		return output.matches(correct);

	}

	private boolean solvedBox(int row, int col) {
		String output = "";
		String correct = "123456789";
		for (int i = 0; i < 9; i++) {
			output = output + Integer.toString(grid[3 * (row / 3) + (i % 3)][3 * (col / 3) + (i / 3)]);
		}
		output = sortString(output);
		return output.matches(correct);

	}

	private String sortString(String string) {
		char temp[] = string.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}

	@Override

	/**
	 * Kollar om siffran number kan sättas i raden row och kolumnen col, om det inte
	 * går enligt spelreglerna returneras false
	 * 
	 * @param row    the row the number should be tried
	 * @param col    the colum the number should be tried
	 * @param number the number that should be tried
	 * @return true if the number is allowed in row row and column col, else returns
	 *         false
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	public boolean trySetNumber(int row, int col, int number) {
		if (number > 9 || number < 1)
			return false;
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == number) {
				return false;
			}
			if (grid[row][i] == number) {
				return false;
			}
			if (grid[3 * (row / 3) + (i % 3)][3 * (col / 3) + (i / 3)] == number) {
				return false;
			}
		}

		return true;
	}

	private static boolean allowedPlacement(int row, int col, int number, int[][] grid) {
		if (number > 9 || number < 1)
			return false;
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == number) {
				return false;
			}
			if (grid[row][i] == number) {
				return false;
			}
			if (grid[3 * (row / 3) + (i % 3)][3 * (col / 3) + (i / 3)] == number) {
				return false;
			}
		}

		return true;
	}

	public static boolean isSolveable(int[][] grid) {
		boolean solve = true;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (!allowedPlacement(row, col, grid[row][col], grid)) {
					solve = false;
				}
			}
		}
		return solve;
	}

	@Override
	public int[][] getNumbers() {
		return grid;
	}

	@Override
	public void setNumbers(int[][] grid) {
		this.grid = grid;

	}
}

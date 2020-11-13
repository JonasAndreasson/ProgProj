package sudoku;

import java.io.*;
import java.util.*;

public class Solver implements SudokuSolver {
	private int[][] grid;

	public Solver() {
		grid = new int[9][9];
		clear();
	}

	@Override
	public void clear() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = 0;
			}
		}

	}

	@Override
	public void setNumber(int row, int col, int number) {
		if (allowedPlacement(row, col, number)) {
			// System.out.println(row + " " + col + " " + number);
			grid[row][col] = number;
		}
	}

	@Override
	public int getNumber(int row, int col) {
		return grid[row][col];
	}

	@Override
	public boolean solve() {
		solveSquare(0, 0);
		return isSolved();
	}

	private void clear(int row, int col) {
		grid[row][col] = 0;
	}

	private void solveSquare(int row, int col) {
		int num = getNumber(row, col);
		if (num == 0) {
			tryPlacing(row, col);
		} else if (!tryPlacing(row, col, num)) {
			return;
		}
		if (row < 8) {
			solveSquare(row + 1, col);
		} else if (row <= 8 && col < 8) {
			solveSquare(0, col + 1);
		} else {
			return;
		}
		solveSquare(row, col);
	}

	private boolean isEmpty(int row, int col) {
		return grid[row][col] == 0;
	}

	private void tryPlacing(int row, int col) {
		for (int i = 1; i < 10; i++) {
			if (allowedPlacement(row, col, i)) {
				setNumber(row, col, i);
			}
		}
	}

	private boolean tryPlacing(int row, int col, int num) {
		int i = num + 1;
		while (i % 10 != num) {
			i = i % 10;
			if (allowedPlacement(row, col, i)) {
				setNumber(row, col, i);
				return true;
			}
			i++;
		}
		if (i % 10 == num) {
			clear(row, col);
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

	private boolean allowedPlacement(int row, int col, int number) {
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
}

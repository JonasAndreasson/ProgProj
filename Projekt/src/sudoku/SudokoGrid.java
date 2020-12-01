package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.*;

public class SudokoGrid {
	private static void createAndShowGUI() {
		final Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);
		final JPanel grid = new JPanel(new GridLayout(9, 0));
		final SudokuSolver solver = new Solver();
		ArrayList<JTextField> list = new ArrayList<>();
		final int[][] matris = new int[9][9];
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				final JTextField field = new JTextField(2);
				field.addCaretListener((e) -> updatedField(e.getSource().toString(), field.getText(), solver));
				
				field.setHorizontalAlignment(JTextField.CENTER); // Center text horizontally in the text field.
				field.setBorder(fieldBorder); // Add the colored border.
				grid.add(field);
				list.add(field);
				if (row < 3 && (col < 3 || col > 5)) { // setting color of textfields
					field.setBackground(Color.GREEN);
				} else if (row < 9 && row > 5 && (col > 5 || col < 3)) {
					field.setBackground(Color.GREEN);
				} else if (row < 6 && row > 2 && col < 6 && col > 2) {
					field.setBackground(Color.GREEN);
				} else {
					field.setBackground(Color.WHITE);
				}

			}
		}

		final JPanel centeredGrid = new JPanel(new GridBagLayout()); // creating ui layout
		centeredGrid.add(grid);
		JPanel butt = new JPanel();
		JButton b = new JButton("Solve");
		JButton b1 = new JButton("Clear");
		butt.add(b, BorderLayout.EAST);
		butt.add(b1, BorderLayout.WEST);
		b.addActionListener(e -> setNumbers(solver, list)); // when button is pressed the puzzle is solved and printed
		b1.addActionListener(e -> clear(list, solver));
		final JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(centeredGrid, BorderLayout.CENTER);
		frame.add(butt, BorderLayout.SOUTH);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void updatedField(String source, String input, SudokuSolver solver) {
		String[] sArray = source.split(",");
		int row = Integer.parseInt(sArray[2]) / 18;
		int col = Integer.parseInt(sArray[1]) / 24;
		int number;
		try {
			number = Integer.parseInt(input);
			if (solver.trySetNumber(row, col, number)) {
				solver.setNumber(row, col, number);
			} else {
				JOptionPane.showMessageDialog(null, number + " is an illegal move at position: " + row + ", "+ col);
			}
		} catch (Exception e) {
			solver.removeNumber(row, col);

		}

	}

	public static void setNumbers(SudokuSolver solve, ArrayList<JTextField> lista) {
		int i = 0;
		if (solve.solve()) {
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					lista.get(i).setText("" + solve.getNumber(row, col));
					i++;
				}
			}
		}
	}

	public static void clear(ArrayList<JTextField> lista, SudokuSolver solver) {
		int i = 0;
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				lista.get(i).setText("");
				i++;
			}
		}
		solver.removeNumber();
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(SudokoGrid::createAndShowGUI);
	}
}

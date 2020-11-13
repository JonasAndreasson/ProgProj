package sudoku;
import sudoku.SudokuSolver;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Comparator;
public class SudokoGrid {

	private SudokoGrid( ) {
		SwingUtilities.invokeLater(() -> createWindow( "Sudoku", 100, 300));
	}
	private void createWindow(String title,int width,int height) {
		JFrame frame=new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		JPanel[][] panels = new JPanel[9][9]; 
		JTextField[][] grid = new JTextField[9][9];
		JPanel mainPanel = new JPanel(new GridLayout(9,9));
		 for (int i = 0; i < panels.length; i++) {
	            for (int j = 0; j < panels[i].length; j++) {
	                panels[i][j] = new JPanel(new GridLayout(9, 9, 1, 1));
	                
	               
	                mainPanel.add(panels[i][j]);
	            }
	        }

	        for (int row = 0; row < grid.length; row++) {
	            for (int col = 0; col <grid[row].length; col++) {
	                grid[row][col] = createField(row, col);
	                int i = row / 3;
	                int j = col / 3;
	                panels[i][j].add(grid[row][col]);
	            }
	        }
	        

		frame.pack();
		frame.setVisible(true);
	} 
	private JTextField createField(int row, int col) {
        JTextField field = new JTextField(1);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setFont(field.getFont().deriveFont(Font.BOLD, 32f));

        return field;
    }
	public static void main(String[]args) {
		new SudokoGrid();
	}
}

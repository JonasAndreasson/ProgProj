package sudoku;
import sudoku.SudokuSolver;
import sudoku.Solver;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Comparator;
public class SudokoGrid {

	private SudokoGrid(Solver solvers ) {
		SwingUtilities.invokeLater(() -> createWindow(solvers, "Sudoku", 1200, 1200));
	}
	private void createWindow(Solver solver,String title,int width,int height) {
		JFrame frame=new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		Container pane1 = frame.getContentPane();
		Container pane2 = frame.getContentPane();
		Container pane3 = frame.getContentPane();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		
		JTextField[][] grid = new JTextField[9][9];
		JPanel mainPanel = new JPanel();
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j]=new JTextField(1);
				switch(i) { 
				case 0: p1.add(grid[i][j]);
				break;
				case 1: p2.add(grid[i][j]);
				break;
				case 2: p3.add(grid[i][j]);
				break;
				case 3: p4.add(grid[i][j]);
				break;
				case 4: p5.add(grid[i][j]);
				break;
				case 5: p6.add(grid[i][j]);
				break;
				case 6: p7.add(grid[i][j]);
				break;
				case 7: p8.add(grid[i][j]);
				break;
				case 8: p9.add(grid[i][j]);
				break;
				}
			}
		}
		
		pane1.add(p1,BorderLayout.NORTH);
		pane1.add(p2,BorderLayout.CENTER);
		pane1.add(p3,BorderLayout.SOUTH);
		/*pane2.add(p4,BorderLayout.NORTH);
		pane2.add(p5,BorderLayout.CENTER);
		pane2.add(p6,BorderLayout.SOUTH);
		pane3.add(p7,BorderLayout.NORTH);
		pane3.add(p8,BorderLayout.CENTER);
		pane3.add(p9,BorderLayout.SOUTH);*/
		
		
		frame.pack();
		frame.setVisible(true);	
	}
	       
	public static void main (String[]args) {
		new SudokoGrid(new Solver());
	}
}


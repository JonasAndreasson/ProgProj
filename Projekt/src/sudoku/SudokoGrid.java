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
        ArrayList<JTextField> list = new ArrayList<>();
        final int[][] matris = new int[9][9];
        for (int row = 0; row < 9; ++row) {
        	for(int col = 0; col<9;col++) {
            final JTextField field = new JTextField(2);
            field.setHorizontalAlignment(JTextField.CENTER); //Center text horizontally in the text field.
            field.setBorder(fieldBorder); //Add the colored border.
            grid.add(field);
            list.add(field);
            }
        }
        
        final JPanel centeredGrid = new JPanel(new GridBagLayout());
        centeredGrid.add(grid);
        JPanel butt = new JPanel();
        JButton b = new JButton("Solve");
        butt.add(b);
        b.addActionListener(e -> toMatrix(list) );
        final JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(centeredGrid,BorderLayout.CENTER);
        frame.add(butt,BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
    public static void toMatrix(ArrayList<JTextField> lista){
    	int[][] mat = new int[9][9];
    	int i = 0;
    	for (int row = 0; row < 9; ++row) {
        	for(int col = 0; col<9;col++) {
        	
        	String s = lista.get(i).getText();
        	if(!s.equals("")) {
        		mat[row][col]=Integer.parseInt(s);	
        	}
        	else {
        		mat[row][col]=0;
        	}
        	i++;
        	}
       }
    	
    	setNumbers(mat);
    }
    
    public static void setNumbers(int[][] pog) {
    	Solver solve = new Solver(pog);
    	if(solve.solve()) {
    		for(int i = 0; i<81;i++) {
    			
    		}
    	}
    }
    
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(SudokoGrid::createAndShowGUI);
    }
}

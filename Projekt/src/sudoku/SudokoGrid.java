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
        final Border fieldBorder = BorderFactory.createLineBorder(Color.WHITE);
        final JPanel grid = new JPanel(new GridLayout(9, 0));
        final Solver solver = new Solver();
        ArrayList<JTextField> list = new ArrayList<>();
        final int[][] matris = new int[9][9];
        for (int row = 0; row < 9; ++row) {
        	for(int col = 0; col<9;col++) {
            final JTextField field = new JTextField(2);
           // field.addCaretListener((e) -> );
            field.setHorizontalAlignment(JTextField.CENTER); //Center text horizontally in the text field.
            field.setBorder(fieldBorder); //Add the colored border.
            grid.add(field);
            list.add(field);
            if(row<3&&(col<3||col>5)) {                   		// setting color of textfields
            	field.setBackground(Color.MAGENTA);
            }
            else if(row<9&&row>5&&(col>5||col<3)) {
            	field.setBackground(Color.MAGENTA);
            }
            else if(row<6&&row>2&&col<6&&col>2) {
            	field.setBackground(Color.MAGENTA);
            }else {
            	field.setBackground(Color.RED);
            }
            
            }
        }
        
        final JPanel centeredGrid = new JPanel(new GridBagLayout());   //creating ui layout
        centeredGrid.add(grid);
        JPanel butt = new JPanel();
        JButton b = new JButton("Solve");
        JButton b1 = new JButton("clear");
        butt.add(b,BorderLayout.EAST);
        butt.add(b1,BorderLayout.WEST);
        b.addActionListener(e -> toMatrix(list) ); // when button is pressed the puzzle is solved and printed
        b1.addActionListener(e -> clear(list) );
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
        	if(!s.equals("")&& Integer.parseInt(s)>0 &&Integer.parseInt(s)<10 ) {
        		mat[row][col]=Integer.parseInt(s);	
        	}
        	else if(s.equals("")) {
        		mat[row][col]=0;
        	}else {
        		JOptionPane.showMessageDialog(null,"Felaktig input");
        		return;
        	}
        	i++;
        	}
       }
    	
    	setNumbers(mat,lista);
    }
    
    public static void setNumbers(int[][] pog,ArrayList<JTextField> lista) {
    	Solver solve = new Solver(pog);
    	int i = 0;
    	if(solve.solve()) {
    		for(int row = 0; row<9;row++) {
    			for(int col = 0; col<9;col++) {
    				lista.get(i).setText(""+solve.getNumber(row, col));
    				i++;
    			}
    		}
    	}
    }
    public static void clear(ArrayList<JTextField> lista) {
    	int i = 0;
    	for(int row = 0; row<9;row++) {
			for(int col = 0; col<9;col++) {
				lista.get(i).setText("");
				i++;
			}
		}
    }
    
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(SudokoGrid::createAndShowGUI);
    }
}

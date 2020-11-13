package sudoku;

public interface SudokuSolver {
	   /** T�mmer hela sudokut */
	   void clear();

	   /** S�tter siffran number p� raden row och kolumnen col. */
	   void setNumber(int row, int col, int number);

	   /** Returnerar siffran p� raden row och kolumnen col. */
	   int getNumber(int row, int col);

	   /** L�ser sudokut och returnerar true om sudokut g�r att l�sa. */
	   boolean solve();
	}

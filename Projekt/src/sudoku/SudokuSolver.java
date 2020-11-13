package sudoku;

public interface SudokuSolver {
	   /** Tömmer hela sudokut */
	   void clear();

	   /** Sätter siffran number på raden row och kolumnen col. */
	   void setNumber(int row, int col, int number);

	   /** Returnerar siffran på raden row och kolumnen col. */
	   int getNumber(int row, int col);

	   /** Löser sudokut och returnerar true om sudokut går att lösa. */
	   boolean solve();
	}

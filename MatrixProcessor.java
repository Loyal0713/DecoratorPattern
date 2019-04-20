package finalProject;

import java.util.ArrayList;

/**
 * Interface used by all matrix classes
 * 
 * @author brown8jt - Josh Brown
 *
 */
public interface MatrixProcessor {

	// returns the matrix
	ArrayList<ArrayList<String>> getList();

	// prints the matrix to the console
	void print();

	// return an array of the rows and columns of the matrix
	int[] getShape();

	// returns the number of rows in the matrix
	public int getNumRows();

	// returns the number of cols in the matrix
	public int getNumCols();

}

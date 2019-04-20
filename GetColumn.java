package finalProject;

import java.util.ArrayList;

class InvalidValueException extends Exception {
	public InvalidValueException(String errMsg) {
		super(errMsg);
	}

}

/**
 * Class representing a set of columns taken from a given matrix
 * 
 * @author brown8jt - Josh Brown
 * @since 4/18/2019
 *
 */
public class GetColumn implements MatrixProcessor {

	// array list of array lists representing 2d matrix
	private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

	// integers representing the size of the 2d matrix
	private int rows, cols;

	/**
	 * Public constructor that takes a matrix processor and multiple integers as
	 * parameters
	 * 
	 * @param mp
	 *            - Matrix processor to be used
	 * @param cols
	 *            - the columns to be added to the matrix
	 */
	public GetColumn(MatrixProcessor mp, int... cols) {

		try {

			// loop through all rows
			for (int i = 0; i < mp.getNumRows(); i++) {

				// column index is out of bounds of matrix
				if (cols[i] - 1 > this.getNumCols()) {
					throw new InvalidValueException("Column index is out of bounds: " + cols[i]);
				}

				// create column array
				ArrayList<String> col = new ArrayList<String>();

				// loop through each given column
				for (int j = 0; j < cols.length; j++) {

					// add element to col
					col.add(mp.getList().get(i).get(cols[j]));

				}

				// add col to matrix
				this.matrix.add(col);

			}
			
			// initialize dimensions
			this.rows = this.matrix.size();
			this.cols = this.matrix.get(0).size();

		} catch (InvalidValueException e) {

			System.err.println(e.toString());
			return;

		}



	}

	/**
	 * Returns the matrix
	 * 
	 * @return returns an array list of array lists representing the 2d matrix
	 */
	@Override
	public ArrayList<ArrayList<String>> getList() {
		return this.matrix;
	}

	/**
	 * Prints the 2d matrix's elements to the console
	 */
	@Override
	public void print() {

		// loop through the 2d matrix
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {

				// print element with 5 space padding
				System.out.printf("%-15s", matrix.get(i).get(j));

			}

			System.out.println();

		}

	}

	/**
	 * Returns an array with two elements corresponding with the row and column size
	 * of the matrix
	 */
	@Override
	public int[] getShape() {

		// initialize dimension matrix
		int[] shape = new int[2];

		// load dimensions into matrix; row then col
		shape[0] = this.rows;
		shape[1] = this.cols;

		return shape;
	}

	/**
	 * Returns the number of rows in the matrix
	 * 
	 * @return - integer representing the number of rows
	 */
	public int getNumRows() {
		return this.rows;
	}

	/**
	 * Returns the number of columns in the matrix
	 * 
	 * @return - integer representing the number of cols
	 */
	public int getNumCols() {
		return this.cols;
	}

}

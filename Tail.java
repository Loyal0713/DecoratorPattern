package finalProject;

import java.util.ArrayList;

/**
 * Class that represents the tail of a matrix where the tail is the bottom x
 * rows of a given matrix
 * 
 * @author brown8jt - Josh Brown
 * @since 4/16/2019
 *
 */
public class Tail implements MatrixProcessor {

	// array list of array lists representing 2d matrix
	private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

	// integers representing the size of the 2d matrix
	private int rows, cols;

	/**
	 * Public constructor that takes a matrix processor and an integer as parameters
	 * 
	 * @param mp
	 *            - Matrix to be used
	 * @param size
	 *            - Integer representing how many rows to be taken from the bottom
	 *            rows of 'mp'
	 */
	public Tail(MatrixProcessor mp, int size) {

		// fill matrix with bottom "size" rows
		for (int i = mp.getList().size() - size; i < mp.getList().size(); i++) {

			this.matrix.add(mp.getList().get(i));

		}
		
		// initialize dimensions
		this.rows = this.matrix.size();
		this.cols = this.matrix.get(0).size();

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

}

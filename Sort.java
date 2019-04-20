package finalProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class that represents a sorted matrix based on a given column index
 * 
 * @author brown8jt - Josh Brown
 * @since 4/18/2019
 *
 */
public class Sort implements MatrixProcessor {

	// array list of array lists representing 2d matrix
	private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

	// integers representing the size of the 2d matrix
	private int rows, cols;

	/**
	 * Public constructor that takes a MatrixProcessor and an integer as parameters
	 * @param mp - Matrix to sort
	 * @param i - Integer representing which column index to sort the matrix by
	 */
	public Sort(MatrixProcessor mp, int i) {

		// initialize matrix
		this.matrix = mp.getList();

		// set dimensions of matrix
		this.rows = this.matrix.size();
		this.cols = this.matrix.get(0).size();

		// sort matrix
		this.sort(i);

	}

	/**
	 * This method sorts the matrix using given index
	 * @param i - Integer representing column index
	 */
	private void sort(int i) {

		Collections.sort(this.getList(), new Comparator<ArrayList<String>>() {

			@Override
			public int compare(ArrayList<String> arg0, ArrayList<String> arg1) {

				// get the two Strings to compare to
				String element1 = arg0.get(i);
				String element2 = arg1.get(i);

				return element1.compareTo(element2);
			}

		});

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

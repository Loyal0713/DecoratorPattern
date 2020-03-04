
import java.util.ArrayList;

/**
 * Class representing a 2d matrix where all elements contain a given string
 *
 * @author Josh Brown
 *
 */
public class Find implements MatrixProcessor {

	// array list of array lists representing 2d matrix
	private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

	// integers representing the size of the 2d matrix
	private int rows, cols;

	public Find(MatrixProcessor mp, String pattern) {

		// loop through every row in mp
		for (int i = 0; i < mp.getNumRows(); i++) {

			// loop through every element
			for (int j = 0; j < mp.getNumCols(); j++) {

				String elementInMatrix = mp.getList().get(i).get(j);

				// check if text contains the pattern
				if (elementInMatrix.toLowerCase().contains(pattern.toLowerCase())) {
					this.matrix.add(mp.getList().get(i));
				}

			}

		}

		this.rows = this.matrix.size();
		this.cols = this.matrix.get(0).size();

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

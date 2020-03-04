
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a basic matrix which elements are strings.
 *
 * @author Josh Brown
 */
public class BasicMatrix implements MatrixProcessor {

	// array list of array lists representing 2d matrix
	private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

	// integers representing the size of the 2d matrix
	private int rows, cols;

	/**
	 * Public constructor for basic matrix
	 *
	 * @param fileName
	 *            - String representing the system location of the file to be read
	 *            in
	 * @throws InvalidMatrixShapeException
	 */
	public BasicMatrix(String fileName) throws InvalidMatrixShapeException {

		// file could be found
		loadCSV(fileName);

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

	/**
	 * Loads a csv file into the matrix
	 *
	 * @param fileName
	 *            - String representing the system location of the csv to be loaded
	 *            in
	 * @throws FileNotFoundException
	 *             - thrown if the given file is not found
	 * @throws InvalidMatrixShapeException
	 *             - thrown if there is a blank entry in the loaded csv file
	 */
	private void loadCSV(String fileName) {

		File file = new File(fileName);
		Scanner fiSc = null;

		// try to create scanner for file
		try {

			// found file
			fiSc = new Scanner(file);

		} catch (FileNotFoundException e) {

			// could not find file
			System.out.println(e.toString());
			return;

		}

		// loop through entire file
		while (fiSc.hasNextLine()) {

			// try to load matrix
			try {

				String[] currLine = fiSc.nextLine().split(",");
				ArrayList<String> newRow = new ArrayList<String>();

				// check if any entries are missing
				for (int i = 0; i < currLine.length; i++) {

					// if there is a missing entry
					if (currLine[i].equals("")) {

						// matrix will be jagged - throw error
						throw new InvalidMatrixShapeException(
								"Matrix cannot be jagged (an element in the matrix is missing!)");

					} else {

						// no missing entry - add element to row
						newRow.add(currLine[i]);

					}

				}

				// add new row to matrix
				this.matrix.add(newRow);

			} catch (InvalidMatrixShapeException e) {

				System.err.println(e.toString());
				return;

			}

		}

		fiSc.close();

		this.rows = this.matrix.size();
		this.cols = this.matrix.get(0).size();

	}

}

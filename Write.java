
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that stores and writes the elements of a matrix to a file in csv format
 *
 * @author Josh Brown
 *
 */
public class Write implements MatrixProcessor {

	// array list of array lists representing 2d matrix
	private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

	// integers representing the size of the 2d matrix
	private int rows, cols;

	/**
	 * Public constructor that takes a matrix processor and a string as parameters
	 *
	 * @param mp
	 *            - MatrixProcessor to write to file
	 * @param fileName
	 *            - System location of the file to write matrix to
	 */
	public Write(MatrixProcessor mp, String fileName) {

		this.matrix = mp.getList();
		this.rows = this.matrix.size();
		this.cols = this.matrix.get(0).size();

		writeToFile(fileName);

	}

	/**
	 * Method used to write matrix to file location
	 *
	 * @param fileName
	 *            - file location name
	 */
	private void writeToFile(String fileName) {

		// string builder to be used to dump matrix to txt file
		StringBuilder sb = new StringBuilder();

		// loop through all elements in matrix
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {

				if (j < this.cols - 1) {

					// this element should be followed by a comma
					sb.append(this.matrix.get(i).get(j) + ",");

				} else {

					// we have reached the end of the row, do not add comma
					sb.append(this.matrix.get(i).get(j));
				}

			}

			// at end of row add new line
			sb.append("\n");

		}

		File output = new File(fileName);
		FileWriter fw;

		try {

			// found file with given name
			fw = new FileWriter(output);
			fw.write(sb.toString());
			fw.flush();
			fw.close();

		} catch (IOException e) {

			// could not find file
			e.printStackTrace();
		}
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

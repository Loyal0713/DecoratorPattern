package finalProject;

public class Main {

	public static void main(String[] args) throws InvalidMatrixShapeException {

		// print loaded matrix
		System.out.println("Load!");
		MatrixProcessor mp = new BasicMatrix("data.csv");
		mp.print();
		printAsterikLine();
		
		// sort by last name
		System.out.println("Sort!");
		mp = new Sort(mp, 1);
		mp.print();
		printAsterikLine();

//		// get top 9 results
//		System.out.println("Get top 9!");
//		mp = new Head(mp, 9);
//		mp.print();
//		printAsterikLine();
//
//		// print to system location
//		System.out.println("Write to desktop!");
//		mp = new Write(mp, "C:\\Users\\Josh Brown\\Desktop\\CPS240.txt");
//		printAsterikLine();
//
//		// find results with elements including the substring 'dragon'
//		System.out.println("Find 'dragon'!");
//		mp = new Find(mp, "dragon");
//		mp.print();
//		printAsterikLine();

		// get columns 0, 1, 3
		System.out.println("Get columns 0, 1, 3!");
		mp = new GetColumn(mp, 0, 1, 3);
		mp.print();
		printAsterikLine();

		// get columns 0 and 2
		System.out.println("Get columns 0, 2!");
		mp = new GetColumn(mp, 0, 2);
		mp.print();
		printAsterikLine();

		// get bottom two results
		System.out.println("Get bottom 2!");
		mp = new Tail(mp, 2);
		mp.print();
		printAsterikLine();

		// get bottom result
		System.out.println("Get bottom 1!");
		mp = new Tail(mp, 1);
		mp.print();
		printAsterikLine();

	}


	/**
	 * This method is used to separate the operations
	 */
	public static void printAsterikLine() {
		System.out.println("******************************************************************************");
	}

}

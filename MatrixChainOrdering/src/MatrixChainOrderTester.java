/*
 * author: Ronald Casasola 012737398
 * 
 */
import java.util.ArrayList;

public class MatrixChainOrderTester {

	public static void main(String[] args) {

		// initialize first array to test
		ArrayList<int[][]> arr = new ArrayList();
		int A1[][] = { { 2, 6 } };
		int A2[][] = { { 5, 10 } };
		int A3[][] = { { 10, 20 } };
		arr.add(A1);
		arr.add(A2);
		arr.add(A3);

		// print array
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i)[0][0] + ", ");
			System.out.println(arr.get(i)[0][1]);
		}
		if (isCompatible(arr)) {
			// make into array
			ArrayList<Integer> a = new ArrayList();
			int[][] temp;
			temp = (int[][]) arr.get(0);
			a.add(temp[0][0]);
			for (int i = 0; i < arr.size(); i++) {
				a.add(arr.get(i)[0][1]);
			}
			Integer[] array = a.toArray(new Integer[0]);

			// initialize matrixChainOrder object
			MatrixChainOrder m = new MatrixChainOrder(arr);
			// print out the order of matrices
			System.out.println("Order of matrices: ");
			for (int i = 1; i < array.length; i++) {
				System.out.println("A" + i + " = " + array[i - 1] + "x" + array[i]);
			}
			// print the optimal parents
			String output = m.toString();
			System.out.println(output);
			// return scalar multiplications
			int y = 0;
			int x = 0;
			for (int i = 0; i < m.getM().length; i++) {
				for (int j = 0; j < m.getM().length; j++) {
					if (y < m.getM()[i][j]) {
						x = y;
						y = m.getM()[i][j];
					}
				}
			}

			System.out.println("Min scalar multiplications: " + x);
		} else {
			System.out.println("Incompatible matrices. ");
		}

		System.out.println();

		// initialize second array to test
		ArrayList<int[][]> arr3 = new ArrayList();
		int C1[][] = { { 2, 5 } };
		int C2[][] = { { 5, 10 } };
		int C3[][] = { { 10, 20 } };
		arr3.add(C1);
		arr3.add(C2);
		arr3.add(C3);

		// print array
		for (int i = 0; i < arr3.size(); i++) {
			System.out.print(arr3.get(i)[0][0] + ", ");
			System.out.println(arr3.get(i)[0][1]);
		}
		if (isCompatible(arr3)) {
			System.out.println("Compatible. ");
			// make into array
			ArrayList<Integer> a3 = new ArrayList();
			int[][] temp3;
			temp3 = (int[][]) arr3.get(0);
			a3.add(temp3[0][0]);
			for (int i = 0; i < arr3.size(); i++) {
				a3.add(arr3.get(i)[0][1]);
			}
			Integer[] array3 = a3.toArray(new Integer[0]);

			// initialize matrixChainOrder object
			MatrixChainOrder m3 = new MatrixChainOrder(arr3);
			// print out the order of matrices
			System.out.println("Order of matrices: ");
			for (int i = 1; i < array3.length; i++) {
				System.out.println("A" + i + " = " + array3[i - 1] + "x" + array3[i]);
			}
			// print the optimal parents
			String output3 = m3.toString();
			System.out.println(output3);
			// return scalar multiplications
			int y3 = 0;
			int x3 = 0;
			for (int i = 0; i < m3.getM().length; i++) {
				for (int j = 0; j < m3.getM().length; j++) {
					if (y3 < m3.getM()[i][j]) {
						x3 = y3;
						y3 = m3.getM()[i][j];
					}
				}
			}

			System.out.println("Min scalar multiplications: " + x3);
		} else {
			System.out.println("Incompatible matrices. ");
		}

		System.out.println();
		// initialize third array to test
		ArrayList<int[][]> arr2 = new ArrayList();
		int B1[][] = { { 10, 20 } };
		int B2[][] = { { 20, 30 } };
		int B3[][] = { { 30, 40 } };
		arr2.add(B1);
		arr2.add(B2);
		arr2.add(B3);

		// print array
		for (int i = 0; i < arr2.size(); i++) {
			System.out.print(arr2.get(i)[0][0] + ", ");
			System.out.println(arr2.get(i)[0][1]);
		}
		if (isCompatible(arr2)) {
			System.out.println("Compatible. ");
			// make into array
			ArrayList<Integer> a2 = new ArrayList();
			int[][] temp2;
			temp2 = (int[][]) arr2.get(0);
			a2.add(temp2[0][0]);
			for (int i = 0; i < arr2.size(); i++) {
				a2.add(arr2.get(i)[0][1]);
			}
			Integer[] array2 = a2.toArray(new Integer[0]);

			// initialize matrixChainOrder object
			MatrixChainOrder m2 = new MatrixChainOrder(arr2);
			// print out the order of matrices
			System.out.println("Order of matrices: ");
			for (int i = 1; i < array2.length; i++) {
				System.out.println("A" + i + " = " + array2[i - 1] + "x" + array2[i]);
			}
			// print the optimal parents
			String output2 = m2.toString();
			System.out.println(output2);
			// return scalar multiplications
			int y2 = 0;
			int x2 = 0;
			for (int i = 0; i < m2.getM().length; i++) {
				for (int j = 0; j < m2.getM().length; j++) {
					if (y2 < m2.getM()[i][j]) {
						x2 = y2;
						y2 = m2.getM()[i][j];
					}
				}
			}

			System.out.println("Min scalar multiplications: " + x2);
		}

	}

	// check if matrices are compatible
	public static boolean isCompatible(ArrayList<int[][]> arr) {
		boolean compatible = true;
		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i)[0][1] != arr.get(i + 1)[0][0]) {
				compatible = false;
			}
		}

		return compatible;

	}

}

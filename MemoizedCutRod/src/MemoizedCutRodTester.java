/*
 * @author: Ronald Casasola
 */

public class MemoizedCutRodTester {

	public static void main(String[] args) {

		//the first row is the lengths and the second is the corresponding prices
		int [][] roddArray = {{1,2,3,4,5,6,7,8,9,10}, {1,5,8,9,10,17,17,20,24,30}};
		
		int[] lengthsToTest = {1,3,5,8,10};
		
		//iterates through array of values to test
		for(int i : lengthsToTest) {
			System.out.println("Length: " + i);
			MemoizedCutRod cutRod = new MemoizedCutRod();
			cutRod.printCutRodSizes(roddArray, i);
			System.out.printf("Max revenue: $%d%n", cutRod.MemoizedCutRod(roddArray, i));
			System.out.println();
		}
		
	
	}

}

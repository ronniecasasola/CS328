/*
 * Tester class for the merger sorter
 * 
 * @author: Ronald Casasola 012737398
 */
public class MergeSorterTester {
	
	public static void main(String[] args) {
		String[] array = {"cat", "application", "dog", "apple", "banana", "comet", "clock", "chair", "dinosaur", "asteroid", "bat", "caramel", "blueberry"};
		System.out.println("Original array");
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
		System.out.println();
		System.out.println("After merge sort");
		MergeSorter.mergeSorter(array);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
}

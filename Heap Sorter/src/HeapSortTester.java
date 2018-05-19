/*
 * author: Ronald Casasola 012737398
 * 
 */

public class HeapSortTester {

	public static void main(String[] args) 
    {
       
		HeapSorter heapSorter = new HeapSorter();
		
		//creates arrays
		Integer numArray[] = {60, 99, 32, 12, 20, 100, 9, 3, 2, 322, 68};
		String stringArray[] = {"apple", "orange", "banana", "cucumber", "pineapple", "peanut", "grape"};
		Double doubleArray[] = {20.2, 19.6, 50.0, 6.6, 18.7, 18.1, 18.3, 18.5, 18.9, 18.5};
		
		//calls heapsorter on array
		heapSorter.heapsort(numArray);
		//prints out array
		System.out.println("number array: ");
		for(int i = 0; i < numArray.length; i++) {
			System.out.println(numArray[i]);
		}
		System.out.println();
		
		heapSorter.heapsort(stringArray);
		System.out.println("string array: ");
		for(int i = 0; i < stringArray.length; i++) {
			System.out.println(stringArray[i]);
		}
		System.out.println();
		
		heapSorter.heapsort(doubleArray);
		System.out.println("double array: ");
		for(int i = 0; i < doubleArray.length; i++) {
			System.out.println(doubleArray[i]);
		}
		System.out.println();
        
                   
    }    

}

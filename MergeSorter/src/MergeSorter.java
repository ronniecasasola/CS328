/*
 * This program is a modification of the merge sort algorithm to 
 * sort an array of strings in lexicographic order
 * 
 * @author: Ronald Casasola 012737398
 */
public class MergeSorter {

	public static void mergeSorter(String[] array) {
		//checks the length of the array to have enough elements
		if (array.length >= 2) {
			//creates a new array of the left half of the original
            String[] left = new String[array.length / 2];
          //creates a new array of the right half of the original
            String[] right = new String[array.length-array.length / 2];

            //copy the contents of the array into the respected halves
            for (int i = 0; i < left.length; i++)
            {
                left[i] = array[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = array[i + array.length / 2];
            }

            //recursively call the function
            mergeSorter(left);
            mergeSorter(right);
            
            //merges and sorts the two halves into array
            merge(array, left, right);
        }
	}
	
	public static void merge(String[] array, String[] left, String[] right) {
        int x = 0;
        int y = 0;
        //iterates through entire array
        for (int i = 0; i < array.length; i++) {
        	//compares the characters of the left and right halves of the array and
        	// sorts them into the array accordingly
            if (y >= right.length || (x < left.length && left[x].compareToIgnoreCase(right[y])<0)) {
                      array[i] = left[x];
                      x++;
                 } else {
                      array[i] = right[y];
                      y++;
                 }
            }
    }
	
}

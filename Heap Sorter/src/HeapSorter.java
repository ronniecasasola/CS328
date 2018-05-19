/*
 * author: Ronald Casasola 012737398
 * 
 */
public class HeapSorter <T extends Comparable<T>> {

	//the length of the array
	private static int N;

	//the parent node
	private int parent(int i) {
		return (i - 1) / 2;

	}

	//the left child node
	private int leftChild(int i) {
		return i * 2 + 1;
	}

	//the right child node
	private int rightChild(int i) {
		return i * 2 + 2;
	}

	//creates a max heap of the array
	private void buildMaxHeap(T[] array) {
		//initializes N and decrements it by 1
		N = array.length - 1;
		//starts at N/2 because it ensures the node we start with is a parent
		for (int i = N / 2; i >= 0; i--)
			maxHeapify(array, i);
	}

	private void maxHeapify(T[] array, int i) {
		//initializes the left child
		int left = leftChild(i);
		//initializes the right child
        int right = rightChild(i);
        //initializes the max 
        int max = i;
        //compares the left child and also compares the left value to the max value
        if (left <= N && array[left].compareTo(array[i]) > 0)
            max = left;
      //compares the right child and also compares the right value to the max value
        if (right <= N && array[right].compareTo(array[max]) > 0)        
            max = right;
 
        //if largest and parent are different we swap
        if (max != i)
        {
            swap(array, i, max);
            maxHeapify(array, max);
        }
	}

	//heapsorts the given array of generic type
	public void heapsort(T[] array) {
		//builds a max heap first
		buildMaxHeap(array);
		for (int i = N; i > 0; i--) {
			swap(array, 0, i);
			N = N - 1;
			maxHeapify(array, 0);
		}
	}

	//swap helper method
	public void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}


}

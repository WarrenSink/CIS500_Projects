public class Sorting {
	
	// Selection Sort
	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[min]) {
					min = j;
				}
			}
			
			// swap list[i] and list[min]
			int temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
	}

	// Bubble Sort
	public static void bubbleSort(int[] list) {
		for (int i = list.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list[j] > list[j+1]) {
					// swap list[j] and list[j+1]
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
	}

	// Bubble Sort Improved
	public static void bubbleSort_Improved(int[] list) {
		boolean exchanges = true;
		for (int i = list.length - 1; i > 0 && exchanges; i--) {
			exchanges = false;
			for (int j = 0; j < i; j++) {
				if (list[j] > list[j+1]) {
					// swap list[j] and list[j+1]
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					exchanges = true;
				}
			}
		}
	}
	
	// Insertion Sort
	public static void insertionSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int key = list[i];
			int j = i;

			// shift larger values up/right
			while (j > 0 && list[j-1] > key) {
				list[j] = list[j-1];
				j--;
			}

			list[j] = key;
		}
	}

	// Quick Sort
	public static void quickSort(int[] list, int from, int to) {
		if (from < to) { // list has more than one element
			int p = partition(list, from, to); // make partitions
			quickSort(list, from, p-1); // sort left partition
			quickSort(list, p+1, to); // sort right partition
		}
	}

	// Helper for Quick Sort
	private static int partition(int[] list, int from, int to) {
		int pivot = list[from];	// use first element of list as pivot value
		int leftmark = from + 1;
		int rightmark = to;
		int temp;

		boolean done = false;
		while (!done) {
			while (leftmark <= rightmark && list[leftmark] <= pivot) {
				leftmark++;
			}
			while (rightmark >= leftmark && list[rightmark] >= pivot) {
				rightmark--;
			}
			if (rightmark < leftmark) {	// done when markers cross
				done = true;
			} else {
				temp = list[leftmark];
				list[leftmark] = list[rightmark];
				list[rightmark] = temp;
			}
		}
		
		// rightmark is the split point so switch pivot value with value at split point
		temp = list[from];
		list[from] = list[rightmark];
		list[rightmark] = temp;
		
		// return split point
		return rightmark;
	}

	// Merge Sort
	public static void mergeSort(int[] list) {
		if (list.length <= 1) {
			return;
		}
		// split data array into two halves
		int[] leftHalf = new int[list.length / 2];
		int[] rightHalf = new int[list.length - leftHalf.length];
		for (int i = 0; i < leftHalf.length; i++) {
			leftHalf[i] = list[i];
		}
		for (int i = 0; i < rightHalf.length; i++) {
			rightHalf[i] = list[leftHalf.length + i];
		}
		
		// sort each half and merge the sorted arrays
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge(leftHalf, rightHalf, list);
	}

	// Helper for Merge Sort
	private static void merge(int[] first, int[] second, int[] result) {
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] < second[iSecond]) {
				result[j] = first[iFirst];
				iFirst++;
			} else {
				result[j] = second[iSecond];
				iSecond++;				
			}
			j++;
		}
		
		// copy any remaining elements of the first array
		while (iFirst < first.length) {
			result[j] = first[iFirst];
			iFirst++;
			j++;
		}
		
		// copy any remaining elements of the second array
		while (iSecond < second.length) {
			result[j] = second[iSecond];
			iSecond++;
			j++;
		}
	}
	
}

import java.util.Arrays;

public class SortDriver {

	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		
		int[] a = ArrayUtil.randomIntArray(100000,100);
		
		// selection sort
		int[] b = Arrays.copyOf(a, a.length);
		timer.reset();
		timer.start();
		Sorting.selectionSort(b);
		timer.stop();
		System.out.println("Elapsed time for selection sort: "
								+ timer.getElapsedTime() + " milliseconds");
		
		// bubble sort
		b = Arrays.copyOf(a, a.length);
		timer.reset();
		timer.start();
		Sorting.bubbleSort(b);
		timer.stop();
		System.out.println("Elapsed time for bubble sort: "
								+ timer.getElapsedTime() + " milliseconds");

		// bubble sort improved
		b = Arrays.copyOf(a, a.length);
		timer.reset();
		timer.start();
		Sorting.bubbleSort_Improved(b);
		timer.stop();
		System.out.println("Elapsed time for bubble sort improved: "
								+ timer.getElapsedTime() + " milliseconds");
		
		// insertion sort
		b = Arrays.copyOf(a, a.length);
		timer.reset();
		timer.start();
		Sorting.insertionSort(b);
		timer.stop();
		System.out.println("Elapsed time for insertion sort: "
								+ timer.getElapsedTime() + " milliseconds");

		// merge sort
		b = Arrays.copyOf(a, a.length);
		timer.reset();
		timer.start();
		Sorting.mergeSort(b);
		timer.stop();
		System.out.println("Elapsed time for merge sort: "
								+ timer.getElapsedTime() + " milliseconds");
		
		// quick sort
		b = Arrays.copyOf(a, a.length);
		timer.reset();
		timer.start();
		Sorting.quickSort(b, 0, b.length - 1);
		timer.stop();
		System.out.println("Elapsed time for quick sort: "
								+ timer.getElapsedTime() + " milliseconds");
	}
	
	// print array
	private static void print(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("]");
	}

}

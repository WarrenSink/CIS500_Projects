import java.util.Arrays;

public class SearchDriver {

	public static void main(String[] args) {
		StopWatch timer = new StopWatch();
		
		int[] a = ArrayUtil.randomIntArray(100000, 100);
		int target = 150;
		a[99999] = target;
		
		// linear search
		timer.reset();
		timer.start();
		int pos = Searching.linearSearch(a, target);
		timer.stop();
		if (pos != -1) {
			System.out.println("Target value found at position " + pos);
		} else {
			System.out.println("Target value not in the array");
		}
		System.out.println("Elapsed time for linear search: "
								+ timer.getElapsedTime() + " milliseconds");
		
		// binary search
		Arrays.sort(a);
		timer.reset();
		timer.start();
		pos = Searching.binarySearch(a, target);
		timer.stop();
		if (pos >= 0) {
			System.out.println("Target value found at position " + pos);
		} else {
			System.out.println("Target value not in the array");
		}
		System.out.println("Elapsed time for binary search: "
								+ timer.getElapsedTime() + " milliseconds");		
	}

}

import java.util.Random;

public class ArrayUtil {

	private static Random generator = new Random();
	
	// Creates and returns an array of specified length filled
	// with random numbers between 0 and n-1.
	public static int[] randomIntArray(int length, int n) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt(n);
		}
		return a;
	}
}

public class Searching {

	// Linear/Sequential Search
	public static int linearSearch(int[] list, int target) {
		
		for (int i = 0; i < list.length; i++) {
			if (list[i] == target) {
				return i;
			}
		}

		return -1;
	}

	// Binary Search
	public static int binarySearch(int[] list, int target) {
		int from = 0, to = list.length - 1;

		while (from <= to) {
			int mid = (from + to) / 2;
			if (target == list[mid]) {
				return mid;
			} else if (target > list[mid]) {
				from = mid + 1;
			} else {
				to = mid - 1;
			}
		}

		return -1;
	}
}

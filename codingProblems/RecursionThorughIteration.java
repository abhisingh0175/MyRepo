package codingProblems;

public class RecursionThorughIteration {

	public static void main(String[] args) {

		int[] arr = { 12, 23, 3, 5, 43, 45, 67, 32, 21, 9, 45, 23 };

	}

	static int binSearch(int first, int end, int[] arr, int key) {
		if (first > end)
			return -1;
		else {
			int mid = (first + end) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				return binSearch(first, mid - 1, arr, key);
			else
				return binSearch(mid + 1, end, arr, key);
		}
	}

	static int binSearchI(int[] arr, int key) {
		int len = arr.length;
		for (int i = 0; i < len;) {
			int mid = (i + len) / 2;
			if (arr[mid] == key)
				return i;
			else if (key < arr[mid]) {
				len = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return -1;
	}

}

package algorithms;

public class MaxContigousSubarraySum {

	public static void main(String[] args) {

		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3, -0, -23, 1234 };
		// int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3, -2, -3, 4, -1, -2, 1, 5,
		// -3, -2, -3, 4, -1, -2, 1, 5, -3 };

		// {4, 7, }

		int[] arr2 = { -2, -3, 4, 5, 8, -1, -2, 1, 5, -3, 4, -3, 6, 9, -2, 3, 1, -4 };
		if (arr2 == null || arr2.length == 0)
			System.exit(1);
		int max = 0;
		int i = 0;
		int maxArr[] = new int[arr.length];
		int count = 0;

		// iterate over the input array
		while (i < arr.length - 1) {
			// keep on adding -ve elements in the previous set by hoping there
			// would be more +ve elements after -ve elements
			while (i < arr.length && arr[i] <= 0) {
				max = max + arr[i++];
			}
			// reset previous sum to zero, if it does not adds any value
			if (max < 0)
				max = 0;
			// prepare the sum of a set of contagious elements starting from
			// a +ve number
			while (i < arr.length && arr[i] >= 0) {
				max = max + arr[i++];
			}
			// save the max candidate
			maxArr[count++] = max;
		}

		max = maxArr[0];
		for (int j = 1; j < maxArr.length; j++) {
			if (max < maxArr[j])
				max = maxArr[j];
		}
		System.out.println(max);
	}
}

package algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		// int[] input = { -98, -12, 0, 12, 23, 34, 55, 57, 78, 103, 678 };
		int[] input = { -1200000, 1200000 };
		int key = 55;

		if (input == null || input.length == 0) {
			System.out.println("Input array is empty");
			System.exit(0);
		}
		for(int i=0;i<input.length-1;i++){
			if(input[i]>input[i+1]){
				System.out.println("Input array is not sorted");
			}
		}

		BinarySearch search = new BinarySearch();

		int index = search.binarySearch(0, input.length - 1, key, input);
		if (index == -1) {
			System.out.println("Key was not found!");
		} else {
			System.out.println("Search key found at index : " + index);
		}
	}

	public int binarySearch(int first, int last, int key, int[] input) {
		if (last - first <= 1) {
			if (input[first] == key)
				return first;
			else if (input[last] == key)
				return last;
			else
				return -1;
		}

		int index = (first + last) / 2;

		if (input[index] == key)
			return index;

		return key > input[index] ? binarySearch(index, last, key, input) : binarySearch(first, index, key, input);
	}

}

package algorithms;

public class MergeSort {

	public static void main(String[] args) {
		int array[] = { 12, 34, 45, -32, 0, 95, 45, 45, 45, 56, 345, 235 };
		if (array != null && array.length > 1) {
			new MergeSort().mergeSort(array, 0, array.length - 1);
		}
	}

	public void mergeSort(int[] array, int left, int right) {
		if (left > right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, right);
		}
	}

	public void merge(int[] array, int left, int right) {
		if((left+right)%2==0){
			
		}
		
		int mid = (left + right) / 2;
		int a = mid - left + 1;
		int b = right - mid;
		int[] first = new int[a];
		int[] second = new int[b];
		for (int i = 0; i < a; i++) {
			first[i] = array[i];
		}
		for (int j = 0; j < b; j++) {
			second[j] = array[a + j];
		}
		int x=0, y=0;
		for(int i=left;i<=right && x<a && y<b;i++){
			array[i]=first[x]<second[y]?first[x++]:second[y++];
		}
	}

}

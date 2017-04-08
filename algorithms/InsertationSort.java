package algorithms;

public class InsertationSort {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3, -0, -23, 1234 };
		int temp=0;
		for(int i=0; i< arr.length; i++){
			for(int j=i+1; j< arr.length; j++){
				if(arr[i]>arr[j]){
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				}
			}	
		}
		
		for(int i=0; i< arr.length; i++){
			System.out.println(arr[i]);
		}
	}

}

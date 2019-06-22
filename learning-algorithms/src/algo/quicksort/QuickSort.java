package algo.quicksort;

public class QuickSort {
	public static void quickSort(int[] arr,int start ,int end) {
		if(start < end) {
			int q = partition(arr,start,end);
			quickSort(arr,start,q - 1);
			quickSort(arr,q+1,end);
		}
	}
	public static int partition(int[] arr,int p,int r) {
		int pivot = arr[r];
		int i = p - 1;
		for(int j=p;j< r ; j++) {
			if(arr[j] <= pivot) {
				i++;		//increment i
				int ival = arr[i];
				int jval = arr[j];
				arr[i] = jval;
				arr[j] = ival;
			}
		}
		//put the pivot in the correct slot
		//swap arr[i+1] with arr[r]
		System.out.println(i);
		int temp1 = arr[i + 1];
		arr[r] = temp1;
		arr[i + 1] = pivot;
		return ( i + 1);
	}
}

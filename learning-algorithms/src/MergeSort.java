import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] arr) {
		mergeSort(arr,0,arr.length - 1);
	}
	public static void mergeSort(int[] arr,int p, int r) {
		if(r <= p) {
			return;
		}
		int mid = (p+r) / 2;
		
			mergeSort(arr,p,mid);
			mergeSort(arr,mid + 1,r);
			merge(arr,p,mid,r);
		

	}
	private static void merge(int[] arr,int start,int mid, int end) {
		int[] mergedArr = new int[end - start + 1];
		int k = 0;
		int leftSlot = start;
		int rightSlot = mid + 1;
		
		while(leftSlot <= mid && rightSlot <= end) {
				if(arr[leftSlot] < arr[rightSlot]) {
					mergedArr[k] = arr[leftSlot];
					leftSlot++;
				}else  {
					mergedArr[k] = arr[rightSlot];
					rightSlot++;
				}
				k++;
		}
		if(leftSlot<= mid) {
			while(leftSlot <= mid) {
				mergedArr[k] = arr[leftSlot];
				leftSlot++;k++;
			}
		}
		if(rightSlot <= end) {
			while(rightSlot <= end) {
				mergedArr[k] = arr[rightSlot];
				rightSlot++;k++;
			}
		}
		
		for(int i = 0;i<mergedArr.length;i++) {
			arr[start + i] = mergedArr[i];
		}
	}
	
}

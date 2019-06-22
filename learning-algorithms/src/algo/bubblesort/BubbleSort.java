package algo.bubblesort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arrayToMerge = {6,4,5,1,3,0,8,55,1,38,5,99,6};
		bubbleSort(arrayToMerge);
		System.out.println("Merged Array :" + Arrays.toString(arrayToMerge));
	}
	public static void bubbleSort(int[] arr) {
		int notSorted = 0;
		int i = 1;
		while(i < arr.length) {
			if(arr[i-1] > arr[i]) {
				int temp = arr[i - 1];
				arr[i - 1 ] = arr[i];
				arr[i] = temp;
				notSorted++;
			}
			i++;
			if(i == arr.length && notSorted !=0) {
				notSorted = 0;
				i = 1; continue;
			}else if (i == arr.length && notSorted == 0) {
				break;
			}
		}
	}
}

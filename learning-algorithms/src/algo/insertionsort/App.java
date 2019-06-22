package algo.insertionsort;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Insertion Sort result :" + Arrays.toString(insertionSort(new int[] {9,8,99,110,8,87,637,8,3,13,87,12,99} ))) ;
	}
	public static int[] insertionSort(int[] arr) {
		//int sortedIndex = 1;
		
		for(int i = 1;i <= arr.length; i ++) {
			int j = i - 1;
			while (j - 1 >= 0) {
				if(arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}else {
					break;
				}
				j--;
			}
			System.out.println("Print array: " + Arrays.toString(arr));
		}
		return arr;
	}
}
